package com.esliceu.rfidpass.amarillo.gestordedatos.modules;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.tools.Card;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

    @Bean
    public Card tarjeta(){
        return new Card();
    }

}
