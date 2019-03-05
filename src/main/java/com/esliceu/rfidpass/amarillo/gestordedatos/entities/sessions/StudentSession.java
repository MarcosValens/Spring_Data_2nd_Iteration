package com.esliceu.rfidpass.amarillo.gestordedatos.entities.sessions;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.courses.Subject;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.Student;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

@Entity
@Table(name = "Estudiante_Sesiones")
public class StudentSession { //Horas de la sesiones con la asignatura.

    @Id private Long id;

    @ManyToOne(cascade=CascadeType.ALL)
    private Student student;

    @ManyToOne
    private Subject subject;

    private String day;
    private String StartHour;
    private Integer durada;
    private String endHour;

    public StudentSession() {}

    public String getDay() {
        return day;
    }

    public String getStartHour() {
        return StartHour;
    }

    public void setStartHour(String startHour) {
        this.StartHour = startHour;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setDay(String day) {this.day = day;}

    public Integer getDurada() {return durada;}

    public void setDurada(Integer durada) {this.durada = durada;}

    public String getEndHour() {return endHour;}

    public void setEndHour(String endHour) {this.endHour = endHour;}

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "StudentSession{" +
                "id=" + id +
                ", student=" + student +
                ", subject=" + subject +
                ", day='" + day + '\'' +
                ", StartHour='" + StartHour + '\'' +
                ", durada=" + durada +
                ", endHour='" + endHour + '\'' +
                '}';
    }
}

