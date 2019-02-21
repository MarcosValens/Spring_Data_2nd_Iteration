package com.esliceu.rfidpass.amarillo.gestordedatos.entities.tools;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.register.Fichaje;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.structures.Aula;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name = "Lector")
public class Lector {

    @Id
    @Column(name = "Id", nullable = false)
    private String id;

    @OneToMany(mappedBy = "lector")
    private ArrayList<Fichaje> fichajes;

    @OneToOne
    @JoinColumn(name = "Id", nullable = false)
    private Aula aula;

    public Lector() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Fichaje> getFichajes() {
        return fichajes;
    }

    public void setFichajes(ArrayList<Fichaje> fichajes) {
        this.fichajes = fichajes;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }
}
