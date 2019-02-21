package com.esliceu.rfidpass.amarillo.gestordedatos.entities.persons;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "Grupo")
public class Grupo {

   @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne(mappedBy = "grupo", fetch = FetchType.LAZY, optional = false)
    private Profesor profesor;

    @OneToMany(mappedBy = "grupo", fetch = FetchType.LAZY)
    private Set<Alumno> alumnos;

    @OneToOne(mappedBy = "grupo", fetch = FetchType.LAZY, optional = false)
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

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
