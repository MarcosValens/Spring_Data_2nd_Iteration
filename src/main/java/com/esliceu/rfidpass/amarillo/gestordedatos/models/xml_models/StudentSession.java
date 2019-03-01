package com.esliceu.rfidpass.amarillo.gestordedatos.models.xml_models;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SESSIO")
@XmlAccessorType(XmlAccessType.FIELD)

public class StudentSession {

    //xml: ScheduleStudents Session

    @XmlAttribute(name="alumne")
    private String StudentCode;
    @XmlAttribute(name="dia")
    private int day;
    @XmlAttribute(name="hora")
    private String hour;


    public String getStudentCode() {
        return StudentCode;
    }

    public void setStudentCode(String studentCode) {
        StudentCode = studentCode;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

}
