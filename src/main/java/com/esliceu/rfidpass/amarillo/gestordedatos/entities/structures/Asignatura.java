package com.esliceu.rfidpass.amarillo.gestordedatos.entities.structures;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.persons.Usuario;
import com.esliceu.rfidpass.amarillo.gestordedatos.resources.DiasSemana;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "Asignatura")
public class Asignatura {

    @Id
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    private Aula aula;

    @Column(name = "Dia", nullable = false)
    private DiasSemana dia;

    @Column(name = "Hora", nullable = false)
    private String hora;

    @Column(name = "HoraFinal", nullable = false)
    private String horaFinal;

    @OneToMany(mappedBy = "asignaturas")
    private Set<Usuario> usuarios;

    public Asignatura() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public DiasSemana getDia() {
        return dia;
    }

    public void setDia(DiasSemana dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }
}
