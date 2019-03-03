package com.esliceu.rfidpass.amarillo.gestordedatos.entities.database;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity //Cursos
@Table(name = "Curso")
public class Course {

    @Id
    private Integer code;

    private String description;

    public Course(){
    }

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
