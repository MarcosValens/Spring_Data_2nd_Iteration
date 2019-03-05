package com.esliceu.rfidpass.amarillo.gestordedatos.modules;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.tools.Card;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpringConfiguration {

    @Bean
    public Card tarjeta(){
        return new Card();
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
