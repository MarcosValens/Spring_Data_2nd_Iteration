package com.esliceu.rfidpass.amarillo.gestordedatos.entities.persons;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.register.Fichaje;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.structures.Asignatura;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.tools.Tarjeta;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @Column(name = "Usuario")
    private String usuario;

    @Column(name = "Contraseña")
    private String contraseña;

    @Column(name = "Dni")
    private String dni;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Apellido")
    private String apellido;

    @Column(name = "Fecha de nacimiento")
    private Date fechaNacimiento;

    @Column(name = "Tarjeta")
    private Tarjeta tarjeta;

    @Column(name = "Fichaje")
    private Fichaje fichaje;

    @Column(name = "Asignaturas")
    private Collection<Asignatura> asignaturas;

}