package com.esliceu.rfidpass.amarillo.gestordedatos.repositories;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.tools.Lector;
import org.springframework.data.repository.CrudRepository;

public interface LectorRepository extends CrudRepository<Lector,Integer> {
}
