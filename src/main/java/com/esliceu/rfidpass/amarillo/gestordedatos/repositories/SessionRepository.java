package com.esliceu.rfidpass.amarillo.gestordedatos.repositories;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.courses.Subject;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.sessions.Session;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface SessionRepository extends CrudRepository<Session, Long> {

    Session findBySubject(Subject subject);
    List<Session> findByDay(String day);
    Set<Session> findByCode(String code);


}
