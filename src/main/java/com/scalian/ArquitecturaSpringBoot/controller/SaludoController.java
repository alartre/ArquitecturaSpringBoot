package com.scalian.ArquitecturaSpringBoot.controller;

import lombok.AllArgsConstructor;
import com.scalian.ArquitecturaSpringBoot.model.Saludo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.scalian.ArquitecturaSpringBoot.service.SaludoService;

@RestController
@RequestMapping("/api")
public class SaludoController {

    public SaludoController(SaludoService saludoService) {
        this.saludoService = saludoService;
    }

    private final SaludoService saludoService;

    @Value("${mensaje.bienvenida}")
    private String mensajeBienvenida;

    @GetMapping("/saludo")
    public Saludo obtenerSaludo(@RequestParam String nombre) {
        return saludoService.generarSaludo(nombre);
    }

    @GetMapping("/saludoValue")
    public Saludo obtenerSaludoValue(@RequestParam String nombre) {
        return new Saludo(mensajeBienvenida + " " + nombre);
    }
}
