package com.esliceu.rfidpass.amarillo.gestordedatos.controllers;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.persons.Alumno;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.persons.Grupo;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.persons.Profesor;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.register.Fichaje;
import com.esliceu.rfidpass.amarillo.gestordedatos.repositories.FichajeRepository;
import com.esliceu.rfidpass.amarillo.gestordedatos.repositories.TeacherRepository;
import com.esliceu.rfidpass.amarillo.gestordedatos.repositories.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

public class FichajeConsulter {

    private FichajeRepository fichajeRepository;
    private TeacherRepository teacherRepository;
    private UserRepository userRepository;

    public FichajeConsulter(FichajeRepository fichajeRepository, TeacherRepository teacherRepository, UserRepository userRepository){
        this.fichajeRepository = fichajeRepository;
        this.teacherRepository = teacherRepository;
        this.userRepository = userRepository;
    }

    @RequestMapping("/getfichajes")
    public Map<String, List<Fichaje>> getFichajes(@RequestParam(value = "TeacherId", defaultValue = "null") String TeacherId){

        Optional<Profesor> teacher = teacherRepository.findById(Integer.parseInt(TeacherId));

        Grupo grupoProfesor = teacher.get().getGrupo();
        List<Alumno> usuariosGrupo= (List<Alumno>) grupoProfesor.getAlumnos();

        Map<String, List<Fichaje>> allFichajes = new HashMap<>();

        for (int i = 0; i < usuariosGrupo.size(); i++) {
            Alumno alumnoaux = usuariosGrupo.get(i);

            List<Fichaje> fichajesAlumno = fichajeRepository.findByUsuario(alumnoaux);
            StringBuilder nameCreator = new StringBuilder();

            nameCreator.append(alumnoaux.getNombre());
            nameCreator.append(" ");
            nameCreator.append(alumnoaux.getApellido());
            allFichajes.put(nameCreator.toString(),fichajesAlumno);
        }

        return allFichajes;
    }
}
