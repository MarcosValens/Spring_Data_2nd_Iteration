package com.esliceu.rfidpass.amarillo.gestordedatos.controllers;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.persons.Alumno;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.persons.Grupo;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.persons.Profesor;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.register.Fichaje;
import com.esliceu.rfidpass.amarillo.gestordedatos.repositories.FichajeRepository;
import com.esliceu.rfidpass.amarillo.gestordedatos.repositories.ProfesorRepository;
import com.esliceu.rfidpass.amarillo.gestordedatos.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class FichajeConsulter {

    private FichajeRepository fichajeRepository;
    private ProfesorRepository ProfesorRepository;
    private UsuarioRepository userRepository;

    @Autowired
    public FichajeConsulter(FichajeRepository fichajeRepository, ProfesorRepository ProfesorRepository, UsuarioRepository userRepository){
        this.fichajeRepository = fichajeRepository;
        this.ProfesorRepository = ProfesorRepository;
        this.userRepository = userRepository;
    }

    @RequestMapping("/getfichajes")
    public Map<String, List<Fichaje>> getFichajes(@RequestParam(value = "TeacherId", defaultValue = "null") String TeacherId){

        Optional<Profesor> teacher = ProfesorRepository.findById(Integer.parseInt(TeacherId));

        Grupo grupoProfesor = teacher.get().getGrupo();
        Set<Alumno> usuariosGrupo= grupoProfesor.getAlumnos();

        Map<String, List<Fichaje>> allFichajes = new HashMap<>();

        for (Alumno alumno : usuariosGrupo) {
            List<Fichaje> fichajesAlumno = fichajeRepository.findByUsuario(alumno);
            StringBuilder nameCreator = new StringBuilder();

            nameCreator.append(alumno.getNombre());
            nameCreator.append(" ");
            nameCreator.append(alumno.getApellido());
            allFichajes.put(nameCreator.toString(), fichajesAlumno);
        }

        return allFichajes;
    }
}
