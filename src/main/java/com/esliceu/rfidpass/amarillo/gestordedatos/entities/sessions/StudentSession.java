package com.esliceu.rfidpass.amarillo.gestordedatos.entities.sessions;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.Student;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.User;

import javax.persistence.*;

@Entity
@DiscriminatorValue("22")
@Table(name = "StudentSession")
public class StudentSession extends Session{ //H

    @ManyToOne(cascade= CascadeType.ALL)
    private Student student;// oras de la sesiones con la asignatura.

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}

