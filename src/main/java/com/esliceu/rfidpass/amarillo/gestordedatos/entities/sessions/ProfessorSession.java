package com.esliceu.rfidpass.amarillo.gestordedatos.entities.sessions;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.courses.Course;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.courses.Group;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.courses.Subject;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.Professor;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

@Entity
@Table(name = "Profesor_Sesiones")
@DiscriminatorValue("11")
public class ProfessorSession extends Session { //Clases de un profesor

    @ManyToOne
    @JoinColumn(name = "grupo_code")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "curso_code")
    private Course course;

    public ProfessorSession() {
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}