package com.esliceu.rfidpass.amarillo.gestordedatos.entities.register;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Fichaje")
public class Fichaje {

    @Id
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Tipo")
    private String tipo;

    @Column(name = "Data")
    private String data;

    public Fichaje() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
