package com.esliceu.rfidpass.amarillo.gestordedatos.entities.persons;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.register.Fichaje;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.structures.Asignatura;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.tools.Tarjeta;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Collection;
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

    private Collection<Asignatura> asignaturas;

}