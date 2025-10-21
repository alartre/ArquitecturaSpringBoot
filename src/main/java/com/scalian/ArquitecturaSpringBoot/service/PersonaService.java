package com.scalian.ArquitecturaSpringBoot.service;

import com.scalian.ArquitecturaSpringBoot.model.dto.PersonaDTO;
import com.scalian.ArquitecturaSpringBoot.model.entity.Persona;
import com.scalian.ArquitecturaSpringBoot.repository.PersonaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonaService {

    private final PersonaRepository personaRepository;

    public List<PersonaDTO> obtenerTodas() {
        return personaRepository.findAll().stream()
                .map(p -> {
                    PersonaDTO personaDTO = new PersonaDTO();
                    personaDTO.setNombre(p.getNombre());
                    personaDTO.setEdad(p.getEdad());
                    return personaDTO;
                })
                .collect(Collectors.toList());

    }

    public Persona crearPersona(PersonaDTO personaDTO) {
        Persona persona = new Persona(null, personaDTO.getNombre(), personaDTO.getEdad());
        return personaRepository.save(persona);
    }
}
