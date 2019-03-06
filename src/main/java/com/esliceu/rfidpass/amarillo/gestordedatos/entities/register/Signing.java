package com.esliceu.rfidpass.amarillo.gestordedatos.entities.register;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.tools.Lector;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.User;

import javax.persistence.*;

@Entity //Unir con los fixajes con los ProfessorSession.
public class Signing {

    @Id
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String date;

    @ManyToOne(fetch = FetchType.LAZY)
    private Lector lector;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Signing() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
