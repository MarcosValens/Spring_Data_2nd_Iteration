package com.esliceu.rfidpass.amarillo.gestordedatos.entities.structures;

public class Asignatura {
    enum dias{LUNES,MARTES,MIERCOLES,JUEVES,VIERNES}
    private String nombre;
    private Aula aula;
    private dias dia;
    private String hora;
}
