package com.esliceu.rfidpass.amarillo.gestordedatos.repositories;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.sessions.ProfessorSession;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfessorSessionRepository extends CrudRepository<ProfessorSession, String> {

    @Query(nativeQuery = true, value = "select distinct group_code from sessio where professor_code = :code")
    List<ProfessorSession> getAllGroups(@Param("code") String code);

}
