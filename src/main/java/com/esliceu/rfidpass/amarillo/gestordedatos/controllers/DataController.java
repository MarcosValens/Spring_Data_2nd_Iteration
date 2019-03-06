package com.esliceu.rfidpass.amarillo.gestordedatos.controllers;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.others.Absence;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.others.SchoolRoom;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.sessions.StudentSession;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.Professor;
import com.esliceu.rfidpass.amarillo.gestordedatos.models.DataContainer;
import com.esliceu.rfidpass.amarillo.gestordedatos.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

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
                          AbsenceRepository absenceRepository, RestTemplate restTemplate) {

        this.courseRepository = courseRepository;
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
        this.professorRepository = professorRepository;
        this.schoolRoomRepository = schoolRoomRepository;
        this.subjectRepository = subjectRepository;
        this.studentSessionRepository = studentSessionRepository;
        this.professorSessionRepository = professorSessionRepository;
        this.absenceRepository = absenceRepository;
        this.restTemplate = restTemplate;
    }

    // Servicio lila para crear / actualizar la base de datos.
    @RequestMapping(value = "/updateData", method = RequestMethod.PUT)
    public boolean updateData(@RequestBody DataContainer data) {

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

        for (int i = 50000, j = 0; i < data.getNumberOfStudentSessions(); i += 50000, j += 50000) {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(data.getPage())
                    .queryParam("start", j)
                    .queryParam("end", i);

            List<StudentSession> studentSessions = restTemplate.getForObject(builder.toUriString(),List.class);
            System.out.println(studentSessions);
            //studentSessionRepository.saveAll(studentSessions);
        }

        return true;
    }

    // Servicio azul para que ellos obtengan las faltas pendientes.
    @RequestMapping(value = "/getTeachers", method = RequestMethod.GET)
    public List<Professor> getTeachers() {

        return new ArrayList<>();
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
