package com.esliceu.rfidpass.amarillo.gestordedatos.entities.users;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.courses.Group;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.sessions.Session;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.sessions.StudentSession;

import javax.persistence.*;
import java.util.Set;

@Entity
@DiscriminatorValue("2")
@Table(name = "Student")
public class Student extends User {

    @OneToMany(mappedBy = "student")
    private Set<StudentSession> studentSessions;

    @ManyToOne
    @JoinColumn(name = "group_code")
    private Group group; //Grupo

    public Student() {}

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Set<StudentSession> getStudentSessions() {
        return studentSessions;
    }

    public void setStudentSessions(Set<StudentSession> studentSessions) {
        this.studentSessions = studentSessions;
    }
}