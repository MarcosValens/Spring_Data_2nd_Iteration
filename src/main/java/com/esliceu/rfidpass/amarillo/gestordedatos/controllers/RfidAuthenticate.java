package com.esliceu.rfidpass.amarillo.gestordedatos.controllers;


import com.esliceu.rfidpass.amarillo.gestordedatos.entities.courses.Group;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.others.Absence;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.register.Signing;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.sessions.Session;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.tools.Lector;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.Professor;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.Student;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.User;
import com.esliceu.rfidpass.amarillo.gestordedatos.models.SigningResponse;
import com.esliceu.rfidpass.amarillo.gestordedatos.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class RfidAuthenticate {

    private final UserRepository userRepository;
    private final SigningRepository signingRepository;
    private final SubjectRepository asignaturaRepository;
    private final GroupRepository groupRepository;
    private final SessionRepository sessionRepository;
    private final AbsenceRepository absenceRepository;
    private final StudentSessionRepository studentSessionRepository;
    private final ProfessorSessionRepository professorSessionRepository;
    private final LectorRepository lectorRepository;

    @Autowired
    public RfidAuthenticate(UserRepository userRepository,
                            SigningRepository signingRepository,
                            SubjectRepository asignaturaRepository,
                            GroupRepository groupRepository, SessionRepository sessionRepository,
                            StudentSessionRepository studentSessionRepository,
                            ProfessorSessionRepository professorSessionRepository,
                            AbsenceRepository absenceRepository,
                            LectorRepository lectorRepository
    ) {
        this.userRepository = userRepository;
        this.signingRepository = signingRepository;
        this.asignaturaRepository = asignaturaRepository;
        this.groupRepository = groupRepository;
        this.sessionRepository = sessionRepository;
        this.studentSessionRepository = studentSessionRepository;
        this.professorSessionRepository = professorSessionRepository;
        this.absenceRepository = absenceRepository;
        this.lectorRepository = lectorRepository;
    }

    @RequestMapping(value = "/validate", method = RequestMethod.POST, consumes = "application/json")
    public String validate(@RequestBody SigningResponse signingResponse) {

        SimpleDateFormat format = new SimpleDateFormat("HH:mm");

        User usuario = userRepository.findByRfid(signingResponse.getRFID());
        int valueToSend;

        if (usuario instanceof Professor) {
            valueToSend = ((Professor) usuario).getGroup() != null ? 2 : 1;
        } else {
            valueToSend = userRepository.existsByRfid(usuario.getRfid()) ? 1 : 0;
        }

        // Signing creation
        String type = valueToSend == 2 ? "Admin" : valueToSend == 1 ? "Success" : "Error";
        Optional<Lector> optLector = lectorRepository.findByIdMachine(signingResponse.getIdMachine());
        Optional<Group> group = groupRepository.findById(391635);
        Lector lector;

        if (!optLector.isPresent()) {
            lector = new Lector();
            lector.setGroup(group.get());
            lector.setIdMachine(signingResponse.getIdMachine());
            lectorRepository.save(lector);
        } else {
            lector = optLector.get();
        }

        Signing signing = new Signing(type, signingResponse.getDate(), lector, usuario);
        signingRepository.save(signing);

        // Absence creation
        String weekDay = signingResponse.getWeekDay();
        List<Session> daySessions = sessionRepository.findByDay(weekDay);

        try {
            Date dateFichaje = format.parse(signingResponse.getTime());
            Session subjectFound = getSubject(daySessions, format, usuario, dateFichaje);

            if (!onTime(signingResponse, subjectFound, format)) {
                Absence absence = new Absence(signingResponse.getDate(), signingResponse.getTime(), subjectFound.getSubject(), usuario);
                System.out.println("Absence: " + absence.toString());
                absenceRepository.save(absence);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return String.valueOf(valueToSend);
    }

    private Session getSubject(List<Session> sessions, SimpleDateFormat formatter, User user, Date dateFichaje) {
        Set<Session> userSessions = sessionRepository.findByCode(user.getCode());
        userSessions = sessions.stream().filter(userSessions::contains).collect(Collectors.toCollection(HashSet::new));

        Date subjectDateStart;
        Date subjectDateEnd;

        try {
            for (Session session : userSessions) {
                subjectDateStart = formatter.parse(session.getStartHour());
                subjectDateEnd = formatter.parse(session.getEndHour());

                if (dateFichaje.compareTo(subjectDateStart) >= 0 && dateFichaje.compareTo(subjectDateEnd) <= 0) {
                    return session;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private boolean onTime(SigningResponse signingResponse, Session session, SimpleDateFormat format) throws ParseException {
        Integer offset = 10;
        String sessionStartDate = session.getStartHour();
        String[] dateSplit = sessionStartDate.split(":");

        Integer sessionStartDateWithOffset = Integer.parseInt(dateSplit[1]) + offset;
        sessionStartDate = dateSplit[0] + ":" + sessionStartDateWithOffset;

        Date now = format.parse(signingResponse.getTime());
        Date subjectTime = format.parse(sessionStartDate);

        return now.compareTo(subjectTime) > 0;
    }

}
