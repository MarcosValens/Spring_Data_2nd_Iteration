package com.esliceu.rfidpass.amarillo.gestordedatos.entities.structures;


import com.esliceu.rfidpass.amarillo.gestordedatos.entities.tools.Lector;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "Aula")
public class Aula {

    @Id
    @Column(name = "Id", nullable = false)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id", nullable = false)
    private Lector lector;

    @OneToMany(mappedBy = "aula")
    @Column(nullable = false)
    private ArrayList<Asignatura> asignaturas;

    public Aula() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }
}
