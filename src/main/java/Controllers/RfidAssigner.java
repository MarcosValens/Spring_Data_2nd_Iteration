package Controllers;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.persons.Usuario;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.tools.Tarjeta;
import com.esliceu.rfidpass.amarillo.gestordedatos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RfidAssigner {
    private final Tarjeta tarjeta;
    private final UserRepository userRepository;

    @Autowired
    public RfidAssigner(Tarjeta tarjeta, UserRepository userRepository) {
        this.tarjeta = tarjeta;
        this.userRepository = userRepository;
    }

    @RequestMapping("/assign")
    public void assign(@RequestParam(value = "tarjetId", defaultValue = "null") String tarjetId,
                          @RequestParam(value = "studentId", defaultValue = "null") String studentId) {
        this.tarjeta.setId(tarjetId);
        Optional<Usuario> optionalUsuario = this.userRepository.findById(Integer.parseInt(studentId));
        Usuario usuario = null;
        if (optionalUsuario.isPresent()) {
            usuario = optionalUsuario.get();
            usuario.setTarjeta(this.tarjeta);
            this.userRepository.save(usuario);
        }


    }
}
