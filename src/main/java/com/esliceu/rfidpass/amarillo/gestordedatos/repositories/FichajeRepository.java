package com.esliceu.rfidpass.amarillo.gestordedatos.repositories;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.persons.Alumno;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.register.Fichaje;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FichajeRepository extends CrudRepository<Fichaje, Integer> {

    List<Fichaje> findByUsuario(Alumno alumno);
}
