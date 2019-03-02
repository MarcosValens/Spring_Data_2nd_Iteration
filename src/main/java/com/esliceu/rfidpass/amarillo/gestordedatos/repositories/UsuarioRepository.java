package com.esliceu.rfidpass.amarillo.gestordedatos.repositories;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.persons.Usuario;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.tools.Tarjeta;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    boolean existsByTarjeta(Tarjeta tarjeta);
    Usuario findByTarjeta(Tarjeta tarjeta);

}
