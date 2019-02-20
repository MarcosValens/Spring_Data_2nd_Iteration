package com.esliceu.rfidpass.amarillo.gestordedatos.entities.persons;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Grupo {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private Profesor profesor;

    private Alumno[] alumnos;

}
