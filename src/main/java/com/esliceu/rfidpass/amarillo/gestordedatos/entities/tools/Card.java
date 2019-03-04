package com.esliceu.rfidpass.amarillo.gestordedatos.entities.tools;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.User;

import javax.persistence.*;

@Entity
@Table(name = "Tarjeta")
public class Card {

    @Id
    @Column(name = "Id", nullable = false)
    private String id;

    @OneToOne(mappedBy = "tarjeta", fetch = FetchType.LAZY, optional = false)
    private User user;

    public Card() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
