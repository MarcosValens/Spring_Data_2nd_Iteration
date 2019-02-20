package com.esliceu.rfidpass.amarillo.gestordedatos.entities.register;

import javax.persistence.Id;

public class Fichaje {

    @Id
    private Integer id;
    private String tipo;
    private String data;

}
