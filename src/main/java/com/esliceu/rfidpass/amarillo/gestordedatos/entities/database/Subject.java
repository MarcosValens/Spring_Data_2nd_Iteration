package com.esliceu.rfidpass.amarillo.gestordedatos.entities.database;


import javax.persistence.*;

@Entity
public class Subject { //Assignatura tiene un curso.

    @Id
    private Integer code;

    private String description;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "course_code")
    private Course course;

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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
