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
public class SigningController {

    private SigningRepository signingRepository;
    private ProfessorRepository ProfessorRepository;

    @Autowired
    public SigningController(SigningRepository signingRepository, ProfessorRepository ProfessorRepository){
        this.signingRepository = signingRepository;
        this.ProfessorRepository = ProfessorRepository;
    }

    @RequestMapping("/getSignings")
    public Map<String, List<Signing>> getSignings(@RequestParam(value = "TeacherId", defaultValue = "null") String TeacherId){

        Optional<Professor> teacher = ProfessorRepository.findById(Integer.valueOf(TeacherId));

        Group grupoProfesor = teacher.get().getGroup();
        Set<Student> usuariosGrupo= grupoProfesor.getStudents();

        Map<String, List<Signing>> allFichajes = new HashMap<>();

        for (Student alumno : usuariosGrupo) {
            List<Signing> fichajesAlumno = signingRepository.findByUser(alumno);
            StringBuilder nameCreator = new StringBuilder();

            nameCreator.append(alumno.getName());
            nameCreator.append(" ");
            nameCreator.append(alumno.getFirstSurname());
            allFichajes.put(nameCreator.toString(), fichajesAlumno);
        }

        return allFichajes;
    }
}
