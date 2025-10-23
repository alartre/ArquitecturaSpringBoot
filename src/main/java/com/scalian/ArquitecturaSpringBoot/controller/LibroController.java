package com.scalian.ArquitecturaSpringBoot.controller;

import com.scalian.ArquitecturaSpringBoot.model.dto.LibroDTO;
import com.scalian.ArquitecturaSpringBoot.model.entity.Libro;
import com.scalian.ArquitecturaSpringBoot.service.LibroService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
@AllArgsConstructor
public class LibroController {

    /**
     * Crear un libro
     * EndPoint: POST /apit/libros
     * Listar todos los libros
     * Endpoint: GET /apit/libros
     * Buscar libros por autor (contenga texto)
     * Endpoint: GET /api/libros/buscar?autor=martin
     * Listar libros con más de X páginas
     * EndPoint: GET /api/libros/mayores?paginas=300
     */

    private final LibroService libroService;

    @PostMapping
    public Libro crearLibro(@RequestBody LibroDTO libroDTO) {
        return libroService.crearLibro(libroDTO);
    }

    @GetMapping
    public List<LibroDTO> listarLibros() {
        return libroService.listarLibros();
    }

    @GetMapping("/buscar")
    public List<LibroDTO> buscarPorAutor(String autor) {
        return libroService.buscarPorAutor(autor);
    }

    @GetMapping("/mayores")
    public List<LibroDTO> buscarPorMinPaginas(int paginas) {
        return libroService.buscarPorMinPaginas(paginas);
    }
}
