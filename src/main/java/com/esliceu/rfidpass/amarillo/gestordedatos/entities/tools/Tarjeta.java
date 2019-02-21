package com.esliceu.rfidpass.amarillo.gestordedatos.entities.tools;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.persons.Usuario;

import javax.persistence.*;

@Entity
@Table(name = "Tarjeta")
public class Tarjeta {

    @Id
    @Column(name = "Id", nullable = false)
    private String id;

    @OneToOne(mappedBy = "tarjeta", fetch = FetchType.LAZY,optional = false)
    private Usuario usuario;

    public Tarjeta() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
