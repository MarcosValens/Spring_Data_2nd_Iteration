package com.esliceu.rfidpass.amarillo.gestordedatos.repositories;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.sessions.Session;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.sessions.StudentSession;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.Student;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentSessionRepository extends CrudRepository<StudentSession, Integer> {
    List<Session> findByStudent(Student student);

    StudentSession findById(Long studentId);

    StudentSession findByStudentId(Long studentId);
}
