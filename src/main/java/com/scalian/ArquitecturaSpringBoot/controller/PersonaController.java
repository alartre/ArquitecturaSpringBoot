package com.scalian.ArquitecturaSpringBoot.controller;

import com.scalian.ArquitecturaSpringBoot.model.dto.PersonaDTO;
import com.scalian.ArquitecturaSpringBoot.model.entity.Persona;
import com.scalian.ArquitecturaSpringBoot.service.PersonaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
@AllArgsConstructor
public class PersonaController {

    private final PersonaService personaService;

    @GetMapping
    public List<PersonaDTO> obtenerTodas() {
        return personaService.obtenerTodas();
    }

    @PostMapping
    public Persona crearPersona(@RequestBody PersonaDTO personaDTO) {
        return personaService.crearPersona(personaDTO);
    }

    //Query
    @GetMapping("/mayores")
    public List<PersonaDTO> getMayoresDe(@RequestParam Integer edad) {
        return personaService.mayoresDeEdad(edad);
    }

    //JPQL
    @GetMapping("/buscar")
    public List<PersonaDTO> buscarPorNombre(@RequestParam String nombre) {
        return personaService.buscarPorNombre(nombre);
    }

    //Native SQL
    @GetMapping("/edad")
    public List<PersonaDTO> buscarPorEdad(@RequestParam int edad) {
        return personaService.buscarPorEdadExacta(edad);
    }

}
