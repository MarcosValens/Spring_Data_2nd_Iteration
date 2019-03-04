package com.esliceu.rfidpass.amarillo.gestordedatos.controllers;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.tools.Card;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.User;
import com.esliceu.rfidpass.amarillo.gestordedatos.repositories.CardRepository;
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
    private final CardRepository cardRepository;

    @Autowired
    public RfidAssigner(Card card, UserRepository userRepository, CardRepository cardRepository) {
        this.card = card;
        this.userRepository = userRepository;
        this.cardRepository = cardRepository;
    }

    @RequestMapping("/assign")
    public void assign(@RequestParam(value = "tarjetId", defaultValue = "null") String tarjetId,
                          @RequestParam(value = "userId", defaultValue = "null") String userId) {

        this.card.setId(tarjetId);

        Optional<User> optionalUsuario = this.userRepository.findById(Integer.parseInt(userId));
        User usuario;

        if (optionalUsuario.isPresent()) {
            usuario = optionalUsuario.get();
            usuario.setCard(this.card);
            this.card.setUser(usuario);
            this.userRepository.save(usuario);
            this.cardRepository.save(this.card);
        }

    }
}
