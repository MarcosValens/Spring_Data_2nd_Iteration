package com.esliceu.rfidpass.amarillo.gestordedatos.entities.persons;

import javax.persistence.Embeddable;

@Embeddable
public class UsuarioId{

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    private String usuario;
    private String contraseña;
}
