package com.esliceu.rfidpass.amarillo.gestordedatos.entities.users;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.courses.Group;

import javax.persistence.*;

@Entity
@DiscriminatorValue("2")
@Table(name = "Student")
public class Student extends User {

    @ManyToOne
    @JoinColumn(name = "group_code")
    private Group group; //Grupo

    public Student() {
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}