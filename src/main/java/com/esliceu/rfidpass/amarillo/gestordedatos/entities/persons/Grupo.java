package com.esliceu.rfidpass.amarillo.gestordedatos.entities.persons;

import javax.persistence.*;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name = "Grupo")
public class Grupo {

    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne(mappedBy = "grupo", fetch = FetchType.LAZY)
    @Column(nullable = false)
    private Profesor profesor;

    @OneToOne(mappedBy = "grupo", fetch = FetchType.LAZY)
    @Column(nullable = false)
    private ArrayList<Alumno> alumnos;

    @Column(name = "Tutor")
    private Profesor tutor;

    public Grupo() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {this.id = id; }

    public Profesor getTutor() {return tutor;}

    public void setTutor(Profesor tutor) {this.tutor = tutor;}

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
