package com.esliceu.rfidpass.amarillo.gestordedatos.controllers;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.User;
import com.esliceu.rfidpass.amarillo.gestordedatos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RfidAssigner {
    private final UserRepository userRepository;

    @Autowired
    public RfidAssigner(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/assign")
    public void assign(@RequestParam(value = "tarjetId", defaultValue = "null") String tarjetId,
                          @RequestParam(value = "userId", defaultValue = "null") String userId) {

        Optional<User> optionalUsuario = this.userRepository.findById(Integer.parseInt(userId));
        User usuario;

        if (optionalUsuario.isPresent()) {
            usuario = optionalUsuario.get();
            usuario.setRfid(tarjetId);
            this.userRepository.save(usuario);
        }

    }
}
