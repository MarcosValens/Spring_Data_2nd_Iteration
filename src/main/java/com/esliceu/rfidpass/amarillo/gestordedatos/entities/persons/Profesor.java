package com.esliceu.rfidpass.amarillo.gestordedatos.entities.persons;

import org.springframework.context.annotation.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Profesor")
public class Profesor {

    @Id
    @Column(name = "Id")
    private int id;

    @Column(name = "Administrador")
    private boolean administrador;

    @Column(name = "Grupo")
    private Grupo grupo;

    public Profesor() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
}
