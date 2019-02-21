package com.esliceu.rfidpass.amarillo.gestordedatos.entities.persons;

import javax.persistence.*;

@Entity
@Table(name = "Alumno")
@DiscriminatorValue("2")
public class Alumno extends Usuario {


    @Column(name = "Matricula")
    private String matricula;

    @Column(name = "Grupo")
    private Grupo grupo;

    public Alumno() {

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
