package com.esliceu.rfidpass.amarillo.gestordedatos.entities.persons;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Alumno")
public class Alumno {

    @Id
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
