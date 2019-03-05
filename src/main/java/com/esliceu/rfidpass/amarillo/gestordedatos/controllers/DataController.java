package com.esliceu.rfidpass.amarillo.gestordedatos.controllers;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.Professor;
import com.esliceu.rfidpass.amarillo.gestordedatos.models.DataContainer;
import com.esliceu.rfidpass.amarillo.gestordedatos.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DataController {

    private final CourseRepository courseRepository;
    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;
    private final ProfessorRepository professorRepository;
    private final ProfessorSessionRepository sessionProfessorRepository;
    private final StudentSessionRepository sessionStudentRepository;
    private final SchoolRoomRepository schoolRoomRepository;
    private final SubjectRepository subjectRepository;


    @Autowired
    public DataController(CourseRepository courseRepository,
                          GroupRepository groupRepository,
                          StudentRepository studentRepository,
                          ProfessorRepository professorRepository,
                          ProfessorSessionRepository sessionProfessorRepository,
                          StudentSessionRepository sessionStudentRepository,
                          SchoolRoomRepository schoolRoomRepository,
                          SubjectRepository subjectRepository) {

        this.courseRepository = courseRepository;
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
        this.professorRepository = professorRepository;
        this.sessionProfessorRepository = sessionProfessorRepository;
        this.sessionStudentRepository = sessionStudentRepository;
        this.schoolRoomRepository = schoolRoomRepository;
        this.subjectRepository = subjectRepository;
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

        sessionProfessorRepository.saveAll(data.getProfessorSessions());
        System.out.println("Sessiones de los profesores añadidos");

        sessionStudentRepository.saveAll(data.getStudentSessions());
        System.out.println("Sessiones de los estudiantes añadidos");

        return true;
    }

    // Servicio azul para que ellos obtengan las faltas pendientes.
    @RequestMapping(value = "/getTeachers", method = RequestMethod.GET)
    public List<Professor> getTeachers() {

        return new ArrayList<>();
    }

}
