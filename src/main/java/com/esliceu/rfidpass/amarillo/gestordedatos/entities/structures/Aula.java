package com.esliceu.rfidpass.amarillo.gestordedatos.entities.structures;


import com.esliceu.rfidpass.amarillo.gestordedatos.entities.tools.Lector;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Aula {

    @Id
    private Integer id;
    private Lector lector;

}
