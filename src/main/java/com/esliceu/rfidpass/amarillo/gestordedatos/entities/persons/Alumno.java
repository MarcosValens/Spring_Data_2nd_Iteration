package com.esliceu.rfidpass.amarillo.gestordedatos.entities.persons;

import javax.persistence.*;

@Entity
@Table(name = "Alumno")
public class Alumno {

    @Id
    @Column(name = "Matricula", nullable = false)
    private String matricula;

    @OneToOne
    @JoinColumn(name = "Id", nullable = false)
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
