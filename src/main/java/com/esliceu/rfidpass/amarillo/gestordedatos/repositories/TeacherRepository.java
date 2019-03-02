package com.esliceu.rfidpass.amarillo.gestordedatos.repositories;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.persons.Profesor;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Profesor, Integer> {
}
