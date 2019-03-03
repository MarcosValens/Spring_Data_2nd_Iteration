package com.esliceu.rfidpass.amarillo.gestordedatos.entities.database;

import javax.persistence.*;

@Entity
@Table(name = "Profesor")
@DiscriminatorValue("1")
public class Professor extends User {

    @OneToOne
    private Group group; //Si es Tutor

    public Professor() {}

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}