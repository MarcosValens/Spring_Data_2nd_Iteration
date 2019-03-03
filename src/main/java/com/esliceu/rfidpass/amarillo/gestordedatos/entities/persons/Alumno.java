package com.esliceu.rfidpass.amarillo.gestordedatos.entities.persons;

import javax.persistence.*;

@Entity
@DiscriminatorValue("2")
public class Alumno extends Usuario {

    @Column(name = "Matricula", nullable = false)
    private String matricula;

    @OneToOne
    private Grupo grupo;

    public Alumno() {

        super();

    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
}
