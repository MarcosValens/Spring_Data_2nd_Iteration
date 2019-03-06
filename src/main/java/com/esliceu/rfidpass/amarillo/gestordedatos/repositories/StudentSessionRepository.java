package com.esliceu.rfidpass.amarillo.gestordedatos.repositories;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.courses.Subject;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.sessions.StudentSession;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentSessionRepository extends CrudRepository<StudentSession, Integer> {

    StudentSession findByStudent_Code(String code);
    StudentSession findBySubject(Subject subject);
    List<StudentSession> findByDay(String day);

}
