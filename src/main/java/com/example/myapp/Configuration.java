package com.example.myapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;

@org.springframework.context.annotation.Configuration
public class Configuration implements WebMvcConfigurer {
    @Bean
    @Scope("singleton")
    public BluePlaqueDatabase bluePlaqueDatabase() throws IOException {
        BluePlaqueDatabase bluePlaqueDatabase = new BluePlaqueDatabase();
        bluePlaqueDatabase.loadBluePlaques();

        return bluePlaqueDatabase;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
}
