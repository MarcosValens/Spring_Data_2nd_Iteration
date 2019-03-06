package com.esliceu.rfidpass.amarillo.gestordedatos.controllers;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.User;
import com.esliceu.rfidpass.amarillo.gestordedatos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
public class RfidAssigner {
    private final UserRepository userRepository;

    @Autowired
    public RfidAssigner(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/assign" , method = RequestMethod.PUT)
    public void assign(@RequestBody() Map<String,String> rfidAssignerResponse) {

        rfidAssignerResponse.forEach((userId,rfid) -> {
            Optional<User> optionalUsuario = this.userRepository.findById(Integer.parseInt(userId));
            User usuario;

            if (optionalUsuario.isPresent()) {
                usuario = optionalUsuario.get();
                usuario.setRfid(rfid);
                this.userRepository.save(usuario);
            }

        });


    }
}
