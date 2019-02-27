package Controllers;


import com.esliceu.rfidpass.amarillo.gestordedatos.entities.persons.Profesor;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.persons.Usuario;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.register.Fichaje;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.structures.Asignatura;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.tools.Tarjeta;
import com.esliceu.rfidpass.amarillo.gestordedatos.repositories.AsignaturaRepository;
import com.esliceu.rfidpass.amarillo.gestordedatos.repositories.FichajeRepository;
import com.esliceu.rfidpass.amarillo.gestordedatos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RfidAuthenticate {

    private final UserRepository userRepository;
    private final Tarjeta tarjeta;
    private final FichajeRepository fichajeRepository;
    private final AsignaturaRepository asignaturaRepository;

    @Autowired
    public RfidAuthenticate(UserRepository userRepository, Tarjeta tarjeta,
                            FichajeRepository fichajeRepository, AsignaturaRepository asignaturaRepository) {
        this.userRepository = userRepository;
        this.tarjeta = tarjeta;
        this.fichajeRepository = fichajeRepository;
        this.asignaturaRepository = asignaturaRepository;
    }

    @RequestMapping("/validate")
    public int validate(@RequestParam(value = "tajetId", defaultValue = "null") String tarjetId) {
        tarjeta.setId(tarjetId);
        Usuario usuario = userRepository.findByTarjeta(tarjeta);
        int valueToSend;
        if (usuario instanceof Profesor) {
            valueToSend = ((Profesor) usuario).isAdministrador() ? 2 : 1;
        } else {
            valueToSend = userRepository.existsByTarjeta(tarjeta) ? 1 : 0;
        }
        return valueToSend;
    }

    // Coso
    @RequestMapping("/ontime")
    public boolean onTime(
            @RequestParam(value = "fichageId", defaultValue = "null") String fichageId,
            @RequestParam(value = "subjectId", defaultValue = "null") String subjectId,
            @RequestParam(value = "userId", defaultValue = "null") String userId
    ) {
        Optional<Fichaje> fichaje = fichajeRepository.findById(Integer.parseInt(fichageId));
        Optional<Asignatura> asignatura = asignaturaRepository.findById(Integer.parseInt(subjectId));
        Optional<Usuario> usuario = userRepository.findById(Integer.parseInt(userId));
        if (asignatura.isPresent() && fichaje.isPresent() && usuario.isPresent()) {
            return isOnTime(fichaje.get(), asignatura.get(), usuario.get());
        }
        return false;
    }

    private boolean isOnTime(Fichaje fichage, Asignatura asignatura, Usuario usuario) {
        String now = fichage.getData();
        return asignatura.getHora().equals(now) && usuario.getAsignaturas().contains(asignatura);
    }
}
