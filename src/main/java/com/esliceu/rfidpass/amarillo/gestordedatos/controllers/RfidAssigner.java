package com.esliceu.rfidpass.amarillo.gestordedatos.controllers;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.tools.Card;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.User;
import com.esliceu.rfidpass.amarillo.gestordedatos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RfidAssigner {
    private final Card card;
    private final UserRepository userRepository;

    @Autowired
    public RfidAssigner(Card card, UserRepository userRepository) {
        this.card = card;
        this.userRepository = userRepository;
    }

    @RequestMapping("/assign")
    public void assign(@RequestParam(value = "tarjetId", defaultValue = "null") String tarjetId,
                          @RequestParam(value = "userId", defaultValue = "null") String studentId) {

        this.card.setId(tarjetId);

        Optional<User> optionalUsuario = this.userRepository.findById(Integer.parseInt(studentId));
        User usuario;

        if (optionalUsuario.isPresent()) {
            usuario = optionalUsuario.get();
            usuario.setCard(this.card);
            this.userRepository.save(usuario);
        }

    }
}
