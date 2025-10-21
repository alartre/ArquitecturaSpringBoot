package com.scalian.ArquitecturaSpringBoot.service;

import com.scalian.ArquitecturaSpringBoot.model.Saludo;
import org.springframework.stereotype.Service;

@Service
public class SaludoService {

    public Saludo generarSaludo(String nombre) {
        return new Saludo("Hola " + nombre + ", ¡bienvenido a Spring Boot");
    }
}
