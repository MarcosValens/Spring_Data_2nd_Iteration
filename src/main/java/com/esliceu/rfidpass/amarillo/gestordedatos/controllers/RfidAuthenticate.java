package com.esliceu.rfidpass.amarillo.gestordedatos.controllers;


import com.esliceu.rfidpass.amarillo.gestordedatos.entities.courses.Subject;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.others.Absence;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.register.Signing;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.sessions.ProfessorSession;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.sessions.Session;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.sessions.StudentSession;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.Professor;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.Student;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.User;
import com.esliceu.rfidpass.amarillo.gestordedatos.models.FichajeResponse;
import com.esliceu.rfidpass.amarillo.gestordedatos.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RfidAuthenticate {

    private final UserRepository userRepository;
    private final SigningRepository signingRepository;
    private final SubjectRepository asignaturaRepository;
    private final SessionRepository sessionRepository;
    private final AbsenceRepository absenceRepository;
    @Autowired
    public RfidAuthenticate(UserRepository userRepository,
                            SigningRepository signingRepository,
                            SubjectRepository asignaturaRepository,
                            SessionRepository sessionRepository,
                            AbsenceRepository absenceRepository
    ) {
        this.userRepository = userRepository;
        this.signingRepository = signingRepository;
        this.asignaturaRepository = asignaturaRepository;
        this.sessionRepository = sessionRepository;
        this.absenceRepository = absenceRepository;
    }

    @RequestMapping("/validate")
    public int validate(@RequestBody FichajeResponse fichajeResponse) {

        System.out.println(fichajeResponse.toString());
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");

        User usuario = userRepository.findByRfid(fichajeResponse.getRFID());
        int valueToSend;

        if (usuario instanceof Professor) {
            valueToSend = ((Professor) usuario).getGroup() != null ? 2 : 1;
        } else {
            valueToSend = userRepository.existsByRfid(usuario.getRfid()) ? 1 : 0;
        }

        User user = userRepository.findByRfid(fichajeResponse.getRFID());
        String weekDay = fichajeResponse.getWeekDay().toString();
        List<Session> daySessions = sessionRepository.findByDay(weekDay);

        try {
            Date dateFichaje = format.parse(fichajeResponse.getTime());
            Subject subjectFound = getSubject(daySessions, format, user, dateFichaje);
            if (!onTime(fichajeResponse, subjectFound, format)){
                Absence absence = new Absence(fichajeResponse.getDate(), fichajeResponse.getTime(), subjectFound, user);
                absenceRepository.save(absence);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return valueToSend;
    }

    private Subject getSubject(List<Session> sessions, SimpleDateFormat formatter, User user, Date dateFichaje) {
        List<Session> userSessions = sessionRepository.findByUser(user);
        userSessions = userSessions.stream().filter(sessions::contains).collect(Collectors.toList());
        Date subjectDateStart;
        Date subjectDateEnd;
        try {
            for (Session session : userSessions) {
                subjectDateStart = formatter.parse(session.getStartHour());
                subjectDateEnd = formatter.parse(session.getEndHour());
                if (dateFichaje.compareTo(subjectDateStart) >= 0 && dateFichaje.compareTo(subjectDateEnd) <= 0) {
                    return session.getSubject();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private boolean onTime(FichajeResponse fichajeResponse, Subject subject, SimpleDateFormat format) throws ParseException {
        Integer offset = 10;
        String sessionStartDate = sessionRepository.findBySubject(subject).getStartHour();
        String[] dateSplit = sessionStartDate.split(":");
        Integer sessionStartDateWithOffset = Integer.parseInt(dateSplit[1]) + offset;
        sessionStartDate = dateSplit[0] + ":" + sessionStartDateWithOffset;

        Date now = format.parse(fichajeResponse.getTime());
        Date subjectTime = format.parse(sessionStartDate);
        return now.compareTo(subjectTime) > 0;
    }

}
