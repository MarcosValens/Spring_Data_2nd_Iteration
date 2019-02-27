package Controllers;


import com.esliceu.rfidpass.amarillo.gestordedatos.entities.tools.Tarjeta;
import com.esliceu.rfidpass.amarillo.gestordedatos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RfidAuthenticate {

    private final UserRepository userRepository;
    private final Tarjeta tarjeta;

    @Autowired
    public RfidAuthenticate(UserRepository userRepository, Tarjeta tarjeta) {
        this.userRepository = userRepository;
        this.tarjeta = tarjeta;
    }

    @RequestMapping("/validate")
    public boolean validate(@RequestParam(value = "tajetId", defaultValue = "null") String tarjetId) {
        tarjeta.setId(tarjetId);

        return userRepository.existsByTarjeta(tarjeta);
    }
}
