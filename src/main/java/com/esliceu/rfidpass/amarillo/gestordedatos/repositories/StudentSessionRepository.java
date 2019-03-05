package com.esliceu.rfidpass.amarillo.gestordedatos.repositories;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.courses.Subject;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.sessions.StudentSession;
import org.springframework.data.repository.CrudRepository;

public interface StudentSessionRepository extends CrudRepository<StudentSession, Integer> {

    StudentSession findByStudent_Code(String code);
    StudentSession findBySubject(Subject subject);

}
