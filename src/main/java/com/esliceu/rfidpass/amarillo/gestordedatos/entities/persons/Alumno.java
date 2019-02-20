package com.esliceu.rfidpass.amarillo.gestordedatos.entities.persons;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alumno {

    @Id
    private String matricula;

    private Grupo grupo;

}
