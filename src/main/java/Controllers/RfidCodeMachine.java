package Controllers;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.structures.Aula;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.tools.Lector;
import com.esliceu.rfidpass.amarillo.gestordedatos.repositories.AulaRepository;
import com.esliceu.rfidpass.amarillo.gestordedatos.repositories.LectorRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RfidCodeMachine {

    private LectorRepository lectorRepository;
    private AulaRepository aulaRepository;

    public RfidCodeMachine(LectorRepository lectorRepository, AulaRepository aulaRepository){
        this.lectorRepository = lectorRepository;
        this.aulaRepository = aulaRepository;
    }

    @RequestMapping("/assigncodemachine")
    public void assigncodemachine(@RequestParam(value = "LectorId", defaultValue = "null") String LectorId,
                                  @RequestParam(value = "AulaId", defaultValue = "null") String AulaId){

        Optional<Lector> lector = lectorRepository.findById(Integer.parseInt(LectorId));
        Optional<Aula> aula = aulaRepository.findById(Integer.parseInt(AulaId));

        lector.ifPresent(lector1 -> lector1.setAula(aula.get()));
        lectorRepository.save(lector.get());

    }
}
