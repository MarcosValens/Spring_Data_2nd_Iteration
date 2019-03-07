package com.esliceu.rfidpass.amarillo.gestordedatos.repositories;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.sessions.StudentSession;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface StudentSessionRepository extends CrudRepository<StudentSession, String> {
}
