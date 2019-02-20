package com.esliceu.rfidpass.amarillo.gestordedatos.entities.tools;

import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.List;

@Repository
public class Lector {

    @Id
    private int id;
    private List idFichaje;
}
