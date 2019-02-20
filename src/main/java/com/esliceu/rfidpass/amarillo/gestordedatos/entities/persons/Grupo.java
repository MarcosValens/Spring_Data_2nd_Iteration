package com.esliceu.rfidpass.amarillo.gestordedatos.entities.persons;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Grupo {

    @Id
    private int id;

    private Profesor profesor;

    private Alumno[] alumnos;

}
