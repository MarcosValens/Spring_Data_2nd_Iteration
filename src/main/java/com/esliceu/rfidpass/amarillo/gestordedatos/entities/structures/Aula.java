package com.esliceu.rfidpass.amarillo.gestordedatos.entities.structures;


import com.esliceu.rfidpass.amarillo.gestordedatos.entities.tools.Lector;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Aula")
public class Aula {

    @Id
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Lector")
    private Lector lector;

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
}
