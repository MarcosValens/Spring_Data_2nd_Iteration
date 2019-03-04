package com.esliceu.rfidpass.amarillo.gestordedatos.entities.users;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.register.Signing;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.tools.Card;

import javax.persistence.*;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Usuario_type", discriminatorType = DiscriminatorType.INTEGER)
@Table(name = "Usuario")
public abstract class User {

    @Id
    @Column(name = "Id")
    private Integer id;

    private String name;
    private String firstSurname;
    private String secondSurname;
    private String username;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    private Card card;

    @OneToMany(mappedBy = "usuario")
    private Set<Signing> signing;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public void setFirstSurname(String firstSurname) {
        this.firstSurname = firstSurname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Set<Signing> getSigning() {
        return signing;
    }

    public void setSigning(Set<Signing> signing) {
        this.signing = signing;
    }
}
