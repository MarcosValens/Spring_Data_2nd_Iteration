package com.esliceu.rfidpass.amarillo.gestordedatos.entities.sessions;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.courses.Subject;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.User;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Sessio_type", discriminatorType = DiscriminatorType.INTEGER)
@Table(name = "Sessio")
public class Session {

    @Id private Long id;

    @ManyToOne
    private Subject subject;

    private String day;
    private String startHour;
    private Integer durada;
    private String endHour;

    @Column(name = "student_id", insertable = false,updatable = false)
    private Long student_id;

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public Integer getDurada() {
        return durada;
    }

    public void setDurada(Integer durada) {
        this.durada = durada;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }
}
