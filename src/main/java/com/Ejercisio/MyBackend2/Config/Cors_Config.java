package com.Ejercisio.MyBackend2.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebMvc
public class Cors_Config implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/*")
        .allowedOrigins("*")//Escribir la Url del proyecto front a conectar
        .allowedMethods("*")//PODEMOS ESPECIFICAR LOS METODOS A PERMITIR DESDE EL FRONT,GET,POST,PUT,DELETE
         .allowCredentials(true);
    }
}
