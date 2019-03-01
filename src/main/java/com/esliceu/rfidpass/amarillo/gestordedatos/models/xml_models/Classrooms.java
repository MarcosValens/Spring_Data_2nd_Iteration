package com.esliceu.rfidpass.amarillo.gestordedatos.models.xml_models;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name="AULES")
@XmlSeeAlso({Classroom.class})
@XmlAccessorType(XmlAccessType.FIELD)
public class Classrooms {

    @XmlElement(name="AULA")
    private List<Classroom> classrooms;


    public List<Classroom> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(List<Classroom> classrooms) {
        this.classrooms = classrooms;
    }
}
