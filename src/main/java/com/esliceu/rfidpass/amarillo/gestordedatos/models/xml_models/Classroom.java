package com.esliceu.rfidpass.amarillo.gestordedatos.models.xml_models;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "AULA")
@XmlAccessorType(XmlAccessType.FIELD)
public class Classroom {

    @XmlAttribute(name="codi")
    private Integer codi;

    @XmlAttribute(name="descripcio")
    private String descripcio;

    public Integer getCodi() {
        return codi;
    }

    public void setCodi(Integer codi) {
        this.codi = codi;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }
}
