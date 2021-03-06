package com.esliceu.rfidpass.amarillo.gestordedatos.entities.tools;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.courses.Group;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.register.Signing;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "Lector")
public class Lector {

    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(mappedBy = "lector")
    private Set<Signing> signings;

    @OneToOne
    @JoinColumn(name = "group_code", nullable = false)
    private Group group;

    private String idMachine;
    public Lector() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Signing> getSignings() {
        return signings;
    }

    public void setSignings(Set<Signing> signings) {
        this.signings = signings;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setIdMachine(String idMachine) {
        this.idMachine = idMachine;
    }

    public String getIdMachine() {
        return idMachine;
    }
}
