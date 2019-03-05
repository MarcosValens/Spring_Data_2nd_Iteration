package com.esliceu.rfidpass.amarillo.gestordedatos.repositories;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.courses.Subject;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.sessions.ProfessorSession;
import org.springframework.data.repository.CrudRepository;

public interface ProfessorSessionRepository extends CrudRepository<ProfessorSession, Integer> {

    ProfessorSession findByProfessor_Code(String code);
    ProfessorSession findBySubject(Subject subject);

}
