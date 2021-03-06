package com.esliceu.rfidpass.amarillo.gestordedatos.controllers;


import com.esliceu.rfidpass.amarillo.gestordedatos.entities.others.Absence;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.others.SchoolRoom;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.sessions.ProfessorSession;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.sessions.Session;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.sessions.StudentSession;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.Professor;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.Student;
import com.esliceu.rfidpass.amarillo.gestordedatos.models.DataContainer;
import com.esliceu.rfidpass.amarillo.gestordedatos.models.notificationModels.AbsenceNotify;
import com.esliceu.rfidpass.amarillo.gestordedatos.models.notificationModels.StudentNotify;
import com.esliceu.rfidpass.amarillo.gestordedatos.models.notificationModels.Teacher;
import com.esliceu.rfidpass.amarillo.gestordedatos.repositories.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DataController {

    private final CourseRepository courseRepository;
    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;
    private final ProfessorRepository professorRepository;
    private final SchoolRoomRepository schoolRoomRepository;
    private final SubjectRepository subjectRepository;
    private final StudentSessionRepository studentSessionRepository;
    private final ProfessorSessionRepository professorSessionRepository;
    private final AbsenceRepository absenceRepository;
    private final ObjectMapper mapper;
    private final RestTemplate restTemplate;

    @Autowired
    public DataController(CourseRepository courseRepository,
                          GroupRepository groupRepository,
                          StudentRepository studentRepository,
                          ProfessorRepository professorRepository,
                          SchoolRoomRepository schoolRoomRepository,
                          SubjectRepository subjectRepository,
                          StudentSessionRepository studentSessionRepository,
                          ProfessorSessionRepository professorSessionRepository,
                          AbsenceRepository absenceRepository, ObjectMapper mapper, RestTemplate restTemplate) {

        this.courseRepository = courseRepository;
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
        this.professorRepository = professorRepository;
        this.schoolRoomRepository = schoolRoomRepository;
        this.subjectRepository = subjectRepository;
        this.studentSessionRepository = studentSessionRepository;
        this.professorSessionRepository = professorSessionRepository;
        this.absenceRepository = absenceRepository;
        this.mapper = mapper;
        this.restTemplate = restTemplate;
    }

    // Servicio lila para crear / actualizar la base de datos.
    @RequestMapping(value = "/updateData", method = RequestMethod.PUT)
    public boolean updateData(@RequestBody DataContainer data) throws IOException {

        courseRepository.saveAll(data.getCourses());
        System.out.println("Cursos añadidos");

        groupRepository.saveAll(data.getGroups());
        System.out.println("Grupos añadidos");

        subjectRepository.saveAll(data.getSubjects());
        System.out.println("Asignaturas añadidas");

        professorRepository.saveAll(data.getProfessors());
        System.out.println("Profesores añadidos");

        studentRepository.saveAll(data.getStudents());
        System.out.println("Estudiantes añadidos");

        schoolRoomRepository.saveAll(data.getSchoolRooms());
        System.out.println("Aulas añadidas");

        professorSessionRepository.saveAll(data.getProfessorSessions());
        System.out.println("Sessiones de los profesores añadidos");

        studentSessionRepository.saveAll(data.getStudentSessions());
        System.out.println("Sessiones de los estudiantes añadidos");

        int numberOfPages = (int) (data.getNumberOfStudentSessions() / 50000);

        for (int i = 1; i <= numberOfPages; i++) {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(data.getPage())
                    .queryParam("start", i)
                    .queryParam("end", 50000);

            String studentSessionsJSON = restTemplate.getForObject(builder.toUriString(), String.class);
            List<StudentSession> studentSessions = mapper.readValue(studentSessionsJSON, new TypeReference<List<StudentSession>>() {
            });
            studentSessionRepository.saveAll(studentSessions);
        }

        return true;
    }

    // Servicio azul para que ellos obtengan las faltas pendientes.
    @RequestMapping(value = "/getTeachers", method = RequestMethod.GET)
    public List<Teacher> getTeachers() {
        List<Teacher> allTeachersWithAbsences = new ArrayList<>();

        Iterable<Professor> professors = professorRepository.findAll();

        professors.forEach(professor -> {
            Iterable<ProfessorSession> sessions = professorSessionRepository.getAllGroups(professor.getCode());

            sessions.forEach(professorSession -> {
                Iterable<Student> students = professorSession.getGroup().getStudents();
                List<StudentNotify> allStudents = new ArrayList<>();

                students.forEach(student -> {
                    List<Absence> absences = absenceRepository.findAllByUser_CodeAndValidatedIsFalse(student.getCode());
                    List<AbsenceNotify> absenceNotifies = new ArrayList<>();

                    absences.forEach(absence -> {
                        absenceNotifies.add(new AbsenceNotify(
                                absence.getDate(),
                                absence.getHour(),
                                absence.getSubject().getDescription()));
                    });

                    if (!absenceNotifies.isEmpty()) {
                        allStudents.add(new StudentNotify(
                                student.getName(),
                                student.getFirstSurname() + " " + student.getSecondSurname(),
                                absenceNotifies));
                    }
                });

                if (!allStudents.isEmpty()) {
                    allTeachersWithAbsences.add(new Teacher(
                            professor.getName(),
                            professor.getFirstSurname() + " " + professor.getSecondSurname(),
                            allStudents));
                }
            });
        });

        return allTeachersWithAbsences;
    }

    // Endpoint per obtenir tots els alumnes:
    @RequestMapping(value = "/getAllStudents")
    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    // Endpoint si fos necessari per obtenir el grup d'un alumne:
    @RequestMapping(value = "/getStudentGroup", method = RequestMethod.POST)
    public String getStudentGroup(@RequestParam("name") String name,
                                  @RequestParam("surname") String surname) {

        List<Student> students = (List<Student>) studentRepository.findAll();
        String group = "";

        for (Student student : students) {
            if (student.getName().equals(name) && student.getFirstSurname().equals(surname)) {
                group = student.getGroup().toString();
            }
        }

        return group;
    }

    @RequestMapping(value = "/getRooms", method = RequestMethod.GET)
    public Iterable<SchoolRoom> getRooms() {
        return schoolRoomRepository.findAll();
    }

    @RequestMapping(value = "/validateAbsence", method = RequestMethod.POST)
    public void validateAbsence(@RequestParam(value = "absences", defaultValue = "null") List<String> absences) {
        for (String absence1 : absences) {
            Absence absence = absenceRepository.findAbsenceById(Integer.valueOf(absence1));
            absence.setValidated(true);
        }
    }
}
