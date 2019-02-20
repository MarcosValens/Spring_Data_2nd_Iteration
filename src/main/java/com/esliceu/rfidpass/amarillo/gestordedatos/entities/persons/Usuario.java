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

    public Usuario() {

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

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

    public Collection<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(Collection<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }
}