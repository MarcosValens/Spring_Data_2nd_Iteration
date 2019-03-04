package com.esliceu.rfidpass.amarillo.gestordedatos.controllers;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.courses.Group;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.tools.Lector;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.Professor;
import com.esliceu.rfidpass.amarillo.gestordedatos.repositories.GroupRepository;
import com.esliceu.rfidpass.amarillo.gestordedatos.repositories.LectorRepository;
import com.esliceu.rfidpass.amarillo.gestordedatos.repositories.ProfessorRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RfidCodeMachine {

    private LectorRepository lectorRepository;
    private GroupRepository aulaRepository;
    private ProfessorRepository professorRepository;

    public RfidCodeMachine(LectorRepository lectorRepository, GroupRepository aulaRepository, ProfessorRepository professorRepository){
        this.lectorRepository = lectorRepository;
        this.aulaRepository = aulaRepository;
        this.professorRepository = professorRepository;
    }

    @RequestMapping("/assigncodemachine")
    public void assigncodemachine(@RequestParam(value = "LectorId", defaultValue = "null") String LectorId,
                                  @RequestParam(value = "AulaId", defaultValue = "null") String AulaId,
                                  @RequestParam(value = "TeacherId", defaultValue = "null") String TeacherId){

        Optional<Professor> profesor = professorRepository.findById(Integer.parseInt(TeacherId));

        if (profesor.isPresent() && profesor.get().getGroup() != null ){
            Optional<Lector> lector = lectorRepository.findById(Integer.parseInt(LectorId));
            Optional<Group> aula = aulaRepository.findById(Integer.parseInt(AulaId));

            lector.ifPresent(lector1 -> lector1.setGroup(aula.get()));
            lectorRepository.save(lector.get());
        }

    }
}
