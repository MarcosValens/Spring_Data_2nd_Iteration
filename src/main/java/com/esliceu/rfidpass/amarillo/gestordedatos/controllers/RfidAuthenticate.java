package com.esliceu.rfidpass.amarillo.gestordedatos.controllers;


import com.esliceu.rfidpass.amarillo.gestordedatos.entities.courses.Subject;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.register.Signing;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.tools.Card;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.Professor;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.User;
import com.esliceu.rfidpass.amarillo.gestordedatos.models.FichajeResponse;
import com.esliceu.rfidpass.amarillo.gestordedatos.repositories.SubjectRepository;
import com.esliceu.rfidpass.amarillo.gestordedatos.repositories.SigningRepository;
import com.esliceu.rfidpass.amarillo.gestordedatos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RfidAuthenticate {

    private final UserRepository userRepository;
    private final Card card;
    private final SigningRepository signingRepository;
    private final SubjectRepository asignaturaRepository;

    @Autowired
    public RfidAuthenticate(UserRepository userRepository, Card card,
                            SigningRepository signingRepository, SubjectRepository asignaturaRepository) {
        this.userRepository = userRepository;
        this.card = card;
        this.signingRepository = signingRepository;
        this.asignaturaRepository = asignaturaRepository;
    }

    @RequestMapping("/validate")
    public int validate(@RequestBody FichajeResponse fichajeResponse) {

        System.out.println(fichajeResponse.toString());

        card.setId(fichajeResponse.getRFID());

        User usuario = userRepository.findByCard(card);
        int valueToSend;

        if (usuario instanceof Professor) {
            valueToSend = ((Professor) usuario).getGroup() != null ? 2 : 1;
        } else {
            valueToSend = userRepository.existsByCard(card) ? 1 : 0;
        }

        return valueToSend;
    }

    @RequestMapping("/ontime")
    public boolean onTime(
            @RequestParam(value = "fichageId", defaultValue = "null") String fichageId,
            @RequestParam(value = "subjectId", defaultValue = "null") String subjectId,
            @RequestParam(value = "userId", defaultValue = "null") String userId
    ) {
        Optional<Signing> fichaje = signingRepository.findById(Integer.parseInt(fichageId));
        Optional<Subject> asignatura = asignaturaRepository.findById(Integer.parseInt(subjectId));
        Optional<User> usuario = userRepository.findById(Integer.parseInt(userId));

        if (asignatura.isPresent() && fichaje.isPresent() && usuario.isPresent()) {
            return isOnTime(fichaje.get(), asignatura.get(), usuario.get());
        }

        return false;
    }

    private boolean isOnTime(Signing fichage, Subject asignatura, User usuario) {
        String now = fichage.getDate();

        //return asignatura.getHora().equals(now) && usuario.getAsignaturas().contains(asignatura);

        return false;
    }
}
