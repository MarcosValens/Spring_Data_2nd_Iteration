package com.esliceu.rfidpass.amarillo.gestordedatos.entities.others;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.courses.Subject;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.User;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Absence {

    @Id
    private Integer id;

    private String date;
    private String hour;
    private Subject subject;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Absence() {}

    public void setDate(String date) {
        this.date = date;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getHour() {
        return hour;
    }

    public Subject getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "Absence{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", hour='" + hour + '\'' +
                ", subject=" + subject +
                ", user=" + user +
                '}';
    }
}
