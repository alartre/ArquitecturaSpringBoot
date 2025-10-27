package com.scalian.ArquitecturaSpringBoot.controller;

import com.scalian.ArquitecturaSpringBoot.model.dto.LibroDTO;
import com.scalian.ArquitecturaSpringBoot.model.dto.PersonaDTO;
import com.scalian.ArquitecturaSpringBoot.model.entity.Libro;
import com.scalian.ArquitecturaSpringBoot.model.entity.Persona;
import com.scalian.ArquitecturaSpringBoot.service.LibroService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/libros")
@AllArgsConstructor

public class LibroController {
    private final LibroService libroService;

    @GetMapping
    public List<LibroDTO> obtenerTodas() {
        return libroService.obtenerTodos();
    }

    @PostMapping
    public Libro crearLibro(@RequestBody LibroDTO libroDTO) {
        return libroService.crearLibro(libroDTO);
    }

    //JPQL
    @GetMapping("/buscar")
    public List<LibroDTO> buscarPorAutor(@RequestParam String autor) {
        return libroService.buscarPorAutor(autor);
    }

    @GetMapping("/mayores")
    public List<LibroDTO> buscarPorPaginasMayores(@RequestParam int paginas) {
        return libroService.buscarPorPaginasMayores(paginas);
    }
}
