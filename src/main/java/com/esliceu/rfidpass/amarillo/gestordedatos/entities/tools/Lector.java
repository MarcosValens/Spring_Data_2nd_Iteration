package com.esliceu.rfidpass.amarillo.gestordedatos.entities.tools;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.register.Fichaje;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table(name = "Lector")
public class Lector {

    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "Fichajes")
    private Collection<Fichaje> fichajes;

    public Lector() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Collection<Fichaje> getFichajes() {
        return fichajes;
    }

    public void setFichajes(Collection<Fichaje> fichajes) {
        this.fichajes = fichajes;
    }
}
