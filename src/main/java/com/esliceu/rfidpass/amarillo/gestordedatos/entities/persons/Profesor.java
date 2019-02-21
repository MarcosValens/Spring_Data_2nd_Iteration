package com.esliceu.rfidpass.amarillo.gestordedatos.entities.persons;

import javax.persistence.*;

@Entity
@Table(name = "Profesor")
public class Profesor {

    @Id
    @Column(name = "Id", nullable = false)
    private int id;

    @Column(name = "Administrador", nullable = false)
    private boolean administrador;

    @OneToOne
    @JoinColumn(name = "Id", nullable = false)
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
