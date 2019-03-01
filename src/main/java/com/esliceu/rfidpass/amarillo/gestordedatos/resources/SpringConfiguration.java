package com.esliceu.rfidpass.amarillo.gestordedatos.resources;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.tools.Tarjeta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

    @Bean
    public Tarjeta tarjeta(){
        return new Tarjeta();
    }

}
