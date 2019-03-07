package com.esliceu.rfidpass.amarillo.gestordedatos.repositories;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.others.Absence;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AbsenceRepository extends CrudRepository<Absence, Integer> {
    Absence findAbsenceById(Integer absenceId);

    List<Absence> findAllByUser_CodeAndValidatedIsFalse(String code);
}
