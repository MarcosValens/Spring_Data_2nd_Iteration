package com.esliceu.rfidpass.amarillo.gestordedatos.entities.persons;

import javax.persistence.*;

@Entity
@DiscriminatorValue("1")
public class Profesor extends Usuario{

    @Column(name = "Administrador")
    private boolean administrador;

    private Grupo grupo;

    public Profesor() {

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
