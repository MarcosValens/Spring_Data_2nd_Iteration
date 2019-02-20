package com.esliceu.rfidpass.amarillo.gestordedatos.entities.persons;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Profesor {

    @Id
    private int id;

    private boolean administrador;

    private Grupo grupo;

}
