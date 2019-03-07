package com.esliceu.rfidpass.amarillo.gestordedatos.repositories;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.sessions.ProfessorSession;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.sessions.Session;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.Professor;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface ProfessorSessionRepository extends CrudRepository<ProfessorSession, Long> {
    Set<ProfessorSession> findByProfessorId(Professor professor);
}
