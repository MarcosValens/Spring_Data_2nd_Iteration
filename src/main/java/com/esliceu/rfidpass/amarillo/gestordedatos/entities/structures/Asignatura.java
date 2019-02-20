package com.esliceu.rfidpass.amarillo.gestordedatos.entities.structures;

import com.esliceu.rfidpass.amarillo.gestordedatos.resources.DiasSemana;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Asignatura")
public class Asignatura {

    @Id
    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Aula")
    private Aula aula;

    @Column(name = "Dia")
    private DiasSemana dia;

    @Column(name = "Hora")
    private String hora;

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
}
