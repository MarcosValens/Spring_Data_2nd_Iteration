package com.esliceu.rfidpass.amarillo.gestordedatos.entities.database;

import javax.persistence.*;

@Entity
@Table(name = "Estudiante")
@DiscriminatorValue("2")
public class Student extends User {

    @ManyToOne
    @JoinColumn(name = "grupo_code")
    private Group group; //Grupo

    public Student() {}

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}