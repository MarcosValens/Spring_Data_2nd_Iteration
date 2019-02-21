package com.esliceu.rfidpass.amarillo.gestordedatos.entities.persons;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.register.Fichaje;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.structures.Asignatura;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.tools.Tarjeta;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Entity(name="Usuario")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Usuario_type",discriminatorType = DiscriminatorType.INTEGER)
@Table(name = "Usuario")
public class Usuario {

    @Id
    @Column(name = "Id")
    private Integer id;

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
    private ArrayList<Asignatura> asignaturas;

    public Usuario() {

    }


    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public Fichaje getFichaje() {
        return fichaje;
    }

    public void setFichaje(Fichaje fichaje) {
        this.fichaje = fichaje;
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }
}