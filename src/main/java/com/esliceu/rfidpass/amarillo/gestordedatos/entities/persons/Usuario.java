package com.esliceu.rfidpass.amarillo.gestordedatos.entities.persons;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.register.Fichaje;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.structures.Asignatura;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.tools.Tarjeta;

import javax.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "Usuario")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Usuario_type",discriminatorType = DiscriminatorType.INTEGER)
@Table(name = "Usuario")
public class Usuario {

    @Id
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Dni", nullable = false)
    private String dni;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "Apellido", nullable = false)
    private String apellido;

    @Column(name = "FechaDeNacimiento", nullable = false)
    private Date fechaNacimiento;

    @Column(name = "Email", nullable = false)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Tarjeta tarjeta;

    @OneToOne(cascade = CascadeType.ALL)
    private Fichaje fichaje;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Asignatura> asignaturas;

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

    public Set<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(Set<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}