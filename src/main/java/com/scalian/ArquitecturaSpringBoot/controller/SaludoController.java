package com.scalian.ArquitecturaSpringBoot.controller;

import com.scalian.ArquitecturaSpringBoot.model.Saludo;
import com.scalian.ArquitecturaSpringBoot.service.SaludoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class SaludoController {

    private final SaludoService saludoService;

    @GetMapping("/saludo")
    public Saludo obtenerSaludo(@RequestParam String nombre) {
        return saludoService.generarSaludo(nombre);
    }
}