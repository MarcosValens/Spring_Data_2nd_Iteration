package com.esliceu.rfidpass.amarillo.gestordedatos.repositories;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.register.Signing;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SigningRepository extends CrudRepository<Signing, Integer> {

    List<Signing> findByUser(Student student);
}
