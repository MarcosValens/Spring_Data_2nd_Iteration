package com.esliceu.rfidpass.amarillo.gestordedatos.entities.database;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SchoolRoom { //Aulas que se ven que no son utiles

    @Id
    private Integer code;

    private String description;

    public SchoolRoom(){}

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
