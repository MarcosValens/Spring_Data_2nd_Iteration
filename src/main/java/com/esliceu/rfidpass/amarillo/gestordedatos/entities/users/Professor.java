package com.esliceu.rfidpass.amarillo.gestordedatos.entities.users;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.courses.Group;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.sessions.ProfessorSession;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.sessions.Session;

import javax.persistence.*;
import java.util.Set;

@Entity
@DiscriminatorValue("1")
@Table(name = "Professor")
public class Professor extends User {

    @OneToMany(mappedBy = "professor")
    private Set<ProfessorSession> professorSessions;

    @OneToOne
    private Group group; //Si es Tutor

    public Professor() {}

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String getCode() {
        return super.getCode();
    }

    @Override
    public void setCode(String code) {
        super.setCode(code);
    }

    public Set<ProfessorSession> getProfessorSessions() {
        return professorSessions;
    }

    public void setProfessorSessions(Set<ProfessorSession> professorSessions) {
        this.professorSessions = professorSessions;
    }
}