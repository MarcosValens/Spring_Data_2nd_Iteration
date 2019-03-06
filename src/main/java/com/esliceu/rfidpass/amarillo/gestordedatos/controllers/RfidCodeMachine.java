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
    private GroupRepository groupRepository;
    private ProfessorRepository professorRepository;

    public RfidCodeMachine(LectorRepository lectorRepository, GroupRepository groupRepository, ProfessorRepository professorRepository){
        this.lectorRepository = lectorRepository;
        this.groupRepository = groupRepository;
        this.professorRepository = professorRepository;
    }

    @RequestMapping("/assignCodeMachine")
    public void assigncodemachine(@RequestParam(value = "lectorId", defaultValue = "null") String lectorId,
                                  @RequestParam(value = "groupId", defaultValue = "null") String groupId,
                                  @RequestParam(value = "teacherId", defaultValue = "null") String teacherId){

        Optional<Professor> profesor = professorRepository.findById(Integer.valueOf(teacherId));

        if (profesor.isPresent() && profesor.get().getGroup() != null ){
            Optional<Lector> optLector = lectorRepository.findById(Integer.parseInt(lectorId));
            Optional<Group> optGroup = groupRepository.findById(Integer.parseInt(groupId));

            optLector.ifPresent(lector -> optGroup.ifPresent(group -> {
                lector.setGroup(group);
                group.setLector(lector);
                lectorRepository.save(lector);
                groupRepository.save(group);
            }));
        }

    }
}
