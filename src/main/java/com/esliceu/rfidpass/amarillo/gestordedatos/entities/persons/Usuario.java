package com.esliceu.rfidpass.amarillo.gestordedatos.entities.persons;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Usuario {

    @Id
    private String usuario;

    private String contraseña;

    private String dni;

    private String nombre;

    private String apellido;

    private Date fechaNacimiento;

    private Tarjeta tarjeta;

    private Fichaje fichaje;

    private Asignatura[] asignaturas;


}