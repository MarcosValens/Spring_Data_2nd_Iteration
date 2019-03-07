package com.esliceu.rfidpass.amarillo.gestordedatos.authentication;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.User;
import com.esliceu.rfidpass.amarillo.gestordedatos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/*
Authentication with username and password
 */

@RestController
public class AuthenticationController {

    private final UserRepository userRepository;

    @Autowired
    public AuthenticationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User login(@RequestBody User user, HttpServletResponse response) {

        User userInDB = userRepository.findByUsername(user.getUsername());

        if (userInDB != null) {

            //Check username
            if (userInDB.getUsername().equals(user.getUsername())) {

                //If username matches check password
                if (userInDB.getPassword().equals(user.getPassword())) {

                    //Return de logged user without password
                    userInDB.setPassword("");

                    return userInDB;
                }
            }
        }

        response.setStatus(401);
        return null;
    }
}
