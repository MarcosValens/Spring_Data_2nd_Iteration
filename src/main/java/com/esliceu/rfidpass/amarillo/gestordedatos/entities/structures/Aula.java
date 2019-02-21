package com.esliceu.rfidpass.amarillo.gestordedatos.entities.structures;


import com.esliceu.rfidpass.amarillo.gestordedatos.entities.tools.Lector;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

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
    private Set<Asignatura> asignaturas;

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

    public Set<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(Set<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }
}
