package com.esliceu.rfidpass.amarillo.gestordedatos.entities.sessions;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.courses.Course;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.courses.Group;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.Professor;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.User;

import javax.persistence.*;

@Entity
@DiscriminatorValue("11")
@Table(name = "ProfessorSession")
public class ProfessorSession extends Session { //Clases de un profesor

    @ManyToOne(cascade=CascadeType.ALL)
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "group_code")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "course_code")
    private Course course;

    public ProfessorSession() {
    }

    public Professor getProfessor() {
        return professor;
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

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}