package com.esliceu.rfidpass.amarillo.gestordedatos.entities.tools;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.register.Fichaje;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.structures.Aula;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Lector")
public class Lector {

    @Id
    @Column(name = "Id", nullable = false)
    private String id;

    @OneToMany(mappedBy = "lector")
    private Collection<Fichaje> fichajes;

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

    public Collection<Fichaje> getFichajes() {
        return fichajes;
    }

    public void setFichajes(Collection<Fichaje> fichajes) {
        this.fichajes = fichajes;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }
}
