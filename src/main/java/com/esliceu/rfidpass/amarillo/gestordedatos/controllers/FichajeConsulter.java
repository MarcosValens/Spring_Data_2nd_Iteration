package com.esliceu.rfidpass.amarillo.gestordedatos.controllers;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.courses.Group;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.register.Signing;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.Professor;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.Student;
import com.esliceu.rfidpass.amarillo.gestordedatos.repositories.SigningRepository;
import com.esliceu.rfidpass.amarillo.gestordedatos.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class FichajeConsulter {

    private SigningRepository signingRepository;
    private ProfessorRepository professorRepository;

    @Autowired
    public FichajeConsulter(SigningRepository signingRepository, ProfessorRepository professorRepository){
        this.signingRepository = signingRepository;
        this.professorRepository = professorRepository;
    }

    @RequestMapping("/getfichajes")
    public Map<String, List<Signing>> getFichajes(@RequestParam(value = "teacherId", defaultValue = "null") String teacherId){
        Map<String, List<Signing>> signings = new HashMap<>();

        // If teacher doesn't exist signings will be empty
        professorRepository.findById(Integer.parseInt(teacherId)).ifPresent(teacher -> {
            Group group = teacher.getGroup();
            Set<Student> users = group.getStudents();
            for (Student student : users) {
                List<Signing> studentSignings = signingRepository.findByUsuario(student);
                StringBuilder name = new StringBuilder();

                name.append(student.getName());
                name.append(" ");
                name.append(student.getFirstSurname());
                signings.put(name.toString(), studentSignings);
            }
        });
        return signings;
    }
}
