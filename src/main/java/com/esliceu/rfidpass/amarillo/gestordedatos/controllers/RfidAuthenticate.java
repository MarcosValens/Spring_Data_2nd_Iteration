package com.esliceu.rfidpass.amarillo.gestordedatos.controllers;


import com.esliceu.rfidpass.amarillo.gestordedatos.entities.courses.Subject;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.register.Signing;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.sessions.ProfessorSession;
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

@RestController
public class RfidAuthenticate {

    private final UserRepository userRepository;
    private final SigningRepository signingRepository;
    private final SubjectRepository asignaturaRepository;
    private final ProfessorSessionRepository professorSessionRepository;
    private final StudentSessionRepository studentSessionRepository;
    @Autowired
    public RfidAuthenticate(UserRepository userRepository,
                            SigningRepository signingRepository,
                            SubjectRepository asignaturaRepository,
                            ProfessorSessionRepository professorSessionRepository,
                            StudentSessionRepository studentSessionRepository
                            ) {
        this.userRepository = userRepository;
        this.signingRepository = signingRepository;
        this.asignaturaRepository = asignaturaRepository;
        this.professorSessionRepository = professorSessionRepository;
        this.studentSessionRepository = studentSessionRepository;
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
        List<StudentSession> studentSession = user instanceof Student ? studentSessionRepository.findByDay(weekDay) : null;
        List<ProfessorSession> professorSession = user instanceof Professor ? professorSessionRepository.findByDay(weekDay) : null;
        Subject subjectFound;

        try {
            Date dateFichaje = format.parse(fichajeResponse.getTime());
            subjectFound = getSubject(studentSession != null ? Collections.singletonList(studentSession)
                    : Collections.singletonList(professorSession), format, dateFichaje);
            onTime(fichajeResponse, subjectFound, user);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return valueToSend;
    }

    private Subject getSubject(List<Object> sessions, SimpleDateFormat formatter, Date dateFichaje) {
        Subject subject = null;
        Integer offset = 10;
        Date subjectDate;
        try {
            for (Object session : sessions) {
                if (session instanceof StudentSession) {
                    StudentSession studentSession = (StudentSession) session;
                    subjectDate = formatter.parse(studentSession.getStartHour());
                    subject = dateFichaje.compareTo(subjectDate) >= 0 ? studentSession.getSubject() : subject;
                } else if (session instanceof ProfessorSession) {
                    ProfessorSession professorSession = (ProfessorSession) session;
                    subjectDate = formatter.parse(professorSession.getStartHour());
                    subject = dateFichaje.compareTo(subjectDate) >= 0 ? professorSession.getSubject() : subject;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return subject;
    }

    private boolean onTime(FichajeResponse fichajeResponse, Subject subject, User user) {
        Integer offset = 10;
        String now = fichajeResponse.getTime();
        String sessionStartDate = user instanceof Professor ?
                professorSessionRepository.findBySubject(subject).getStartHour() :
                studentSessionRepository.findBySubject(subject).getStartHour();
        String[] dateSplit = sessionStartDate.split(":");
        Integer sessionStartDateWithOffset = Integer.parseInt(dateSplit[1]) + offset;
        sessionStartDate = dateSplit[0]+":"+sessionStartDateWithOffset;
        //return asignatura.getHora().equals(now) && usuario.getAsignaturas().contains(asignatura);

        return false;
    }

}
