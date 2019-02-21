package Controllers;


import com.esliceu.rfidpass.amarillo.gestordedatos.entities.tools.Tarjeta;
import com.esliceu.rfidpass.amarillo.gestordedatos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RfidAuthenticate {

    @Autowired
    UserRepository userRepository;


    @RequestMapping("/validate")
    public boolean validate (@RequestParam(value="uuid", defaultValue="") String name){
        return  true;
    }
}
