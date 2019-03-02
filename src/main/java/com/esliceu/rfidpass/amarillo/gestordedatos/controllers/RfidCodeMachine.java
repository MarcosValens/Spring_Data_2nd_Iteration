package com.esliceu.rfidpass.amarillo.gestordedatos.controllers;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.persons.Profesor;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.structures.Aula;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.tools.Lector;
import com.esliceu.rfidpass.amarillo.gestordedatos.repositories.AulaRepository;
import com.esliceu.rfidpass.amarillo.gestordedatos.repositories.LectorRepository;
import com.esliceu.rfidpass.amarillo.gestordedatos.repositories.ProfesorRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RfidCodeMachine {

    private LectorRepository lectorRepository;
    private AulaRepository aulaRepository;
    private ProfesorRepository profesorRepository;
    public RfidCodeMachine(LectorRepository lectorRepository, AulaRepository aulaRepository,ProfesorRepository profesorRepository){
        this.lectorRepository = lectorRepository;
        this.aulaRepository = aulaRepository;
        this.profesorRepository = profesorRepository;
    }

    @RequestMapping("/assigncodemachine")
    public void assigncodemachine(@RequestParam(value = "LectorId", defaultValue = "null") String LectorId,
                                  @RequestParam(value = "AulaId", defaultValue = "null") String AulaId,
                                  @RequestParam(value = "TeacherId", defaultValue = "null") String TeacherId){

        Optional<Profesor> profesor = profesorRepository.findById(Integer.parseInt(TeacherId));

        if (profesor.isPresent() && profesor.get().isAdministrador() ){
            Optional<Lector> lector = lectorRepository.findById(Integer.parseInt(LectorId));
            Optional<Aula> aula = aulaRepository.findById(Integer.parseInt(AulaId));

            lector.ifPresent(lector1 -> lector1.setAula(aula.get()));
            lectorRepository.save(lector.get());
        }

    }
}
