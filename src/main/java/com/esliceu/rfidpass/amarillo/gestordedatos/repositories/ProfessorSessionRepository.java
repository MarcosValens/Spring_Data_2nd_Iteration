package com.esliceu.rfidpass.amarillo.gestordedatos.repositories;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.sessions.ProfessorSession;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.sessions.Session;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.Professor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProfessorSessionRepository extends CrudRepository<ProfessorSession, Integer> {
    List<Session> findByProfessor(Professor professor);

    @Query("select distinct group_code from sessio where professor_code = ?1")
    List<ProfessorSession> getAllGroups(String professorCode);

}
