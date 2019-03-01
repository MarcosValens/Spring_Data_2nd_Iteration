package com.esliceu.rfidpass.amarillo.gestordedatos.controllers;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.persons.Profesor;
import com.esliceu.rfidpass.amarillo.gestordedatos.models.Center;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

@RestController
public class DataController {

    // Servicio lila para crear / actualizar la base de datos.
    @RequestMapping(value = "/updateData",  method = RequestMethod.PUT)
    public boolean updateData(@RequestBody String data) {
        Center center = xmlParser(data);

        System.out.println(center);

        return false;
    }

    // Servicio azul para que ellos obtengan las faltas pendientes.
    @RequestMapping(value = "/getTeachers", method = RequestMethod.POST)
    public Profesor getTeachers() {

        return new Profesor();
    }

    private Center xmlParser(String xml){
        StringReader reader = new StringReader(xml);
        JAXBContext jaxbContext;
        Unmarshaller unmarshaller;

        try {
            jaxbContext = JAXBContext.newInstance(Center.class);
            unmarshaller = jaxbContext.createUnmarshaller();
            return (Center) unmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }

}
