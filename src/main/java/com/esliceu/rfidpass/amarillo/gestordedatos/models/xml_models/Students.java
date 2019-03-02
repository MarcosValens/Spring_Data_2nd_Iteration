package com.esliceu.rfidpass.amarillo.gestordedatos.models.xml_models;


import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name="ALUMNES")
@XmlSeeAlso({Student.class})
@XmlAccessorType(XmlAccessType.FIELD)
public class Students {

    @XmlElement(name="ALUMNE")
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
