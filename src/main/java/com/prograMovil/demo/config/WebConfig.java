package com.prograMovil.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
   @Bean
   public WebMvcConfigurer corsConfigurer() {
       return new WebMvcConfigurer() {
           @Override
           public void addCorsMappings(CorsRegistry registry) {
               /*registry.addMapping("/**") // Permite CORS en todos los endpoints
                       .allowedOrigins("http://localhost:8100") // Origen permitido (Ionic)
                       .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH") // Métodos permitidos
                       .allowCredentials(true);*/
               registry.addMapping("/**")
                       .allowedOrigins("*")
                       .allowedMethods("*")
                       .allowedHeaders("*");
           }
       };
   }
}

