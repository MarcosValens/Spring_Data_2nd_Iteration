package com.esliceu.rfidpass.amarillo.gestordedatos.repositories;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.persons.Usuario;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.tools.Tarjeta;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository  extends CrudRepository<Usuario, Integer> {

    boolean existsByTarjeta(Tarjeta tarjeta);

}
