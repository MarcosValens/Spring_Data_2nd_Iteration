package com.esliceu.rfidpass.amarillo.gestordedatos.entities.sessions;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("22")
@Table(name = "StudentSession")
public class StudentSession extends Session{ //Horas de la sesiones con la asignatura.

}

