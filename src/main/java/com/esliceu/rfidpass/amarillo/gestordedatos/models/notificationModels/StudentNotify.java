package com.esliceu.rfidpass.amarillo.gestordedatos.models.notificationModels;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.others.Absence;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by tanin on 20/02/2019.
 */
@Component
public class StudentNotify {

    private String name;
    private String surname;

    @JsonProperty
    private List<AbsenceNotify> absenceNotifies;

    public StudentNotify(){}

    public StudentNotify(String name, String surname, List<AbsenceNotify> absenceNotifies) {
        this.name = name;
        this.surname = surname;
        this.absenceNotifies = absenceNotifies;
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

    public List<AbsenceNotify> getAbsenceNotifies() {
        return absenceNotifies;
    }

    public void setAbsenceNotifies(List<AbsenceNotify> absenceNotifies) {
        this.absenceNotifies = absenceNotifies;
    }

    @Override
    public String toString() {
        return "student{" +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", absences=" + absenceNotifies +
                '}';
    }
}


