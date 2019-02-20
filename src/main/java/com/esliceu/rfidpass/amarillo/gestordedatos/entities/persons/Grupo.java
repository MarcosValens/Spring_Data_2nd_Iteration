package com.esliceu.rfidpass.amarillo.gestordedatos.entities.persons;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Grupo")
public class Grupo {

    @Id
    @Column(name = "Id")
    private int id;

    @Column(name = "Profesor")
    private Profesor profesor;

    @Column(name = "Alumnos")
    private Alumno[] alumnos;

    public Grupo() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Alumno[] getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Alumno[] alumnos) {
        this.alumnos = alumnos;
    }
}
