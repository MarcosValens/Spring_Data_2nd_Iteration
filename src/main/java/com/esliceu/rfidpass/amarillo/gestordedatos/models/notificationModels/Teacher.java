package com.esliceu.rfidpass.amarillo.gestordedatos.models.notificationModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * Created by tanin on 20/02/2019.
 */
@Component
public class Teacher {
    private String name, surname;

    @JsonProperty
    private List<StudentNotify> studentNotifies;

    public Teacher() {
    }

    public Teacher(String name, String surname, List<StudentNotify> studentNotifies) {
        this.name = name;
        this.surname = surname;
        this.studentNotifies = studentNotifies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<StudentNotify> getStudentNotifies() {
        return studentNotifies;
    }

    public void setStudentNotifies(List<StudentNotify> studentNotifies) {
        this.studentNotifies = studentNotifies;
    }
}
