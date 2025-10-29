package com.scalian.ArquitecturaSpringBoot.controller;

import com.scalian.ArquitecturaSpringBoot.model.dto.LibroDTO;
import com.scalian.ArquitecturaSpringBoot.model.entity.Libro;
import com.scalian.ArquitecturaSpringBoot.service.LibroService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Libro crearLibro(@Valid @RequestBody LibroDTO libroDTO) {
        return libroService.crearLibro(libroDTO);
    }

//    @GetMapping
//    public List<LibroDTO> listarLibros() {
//        return libroService.listarLibros();
//    }

    @GetMapping
    public Page<LibroDTO> listarLibros(Pageable pageable) {
        return libroService.listarLibrosPaginado(pageable);
    }

//    @GetMapping("/buscar")
//    public List<LibroDTO> buscarPorAutor(String autor) {
//        return libroService.buscarPorAutor(autor);
//    }

    @GetMapping("/buscar")
    public Page<LibroDTO> buscarPorAutor(String autor, Pageable pageable) {
        return libroService.buscarPorAutorPaginado(autor, pageable);
    }

    @GetMapping("/mayores")
    public List<LibroDTO> buscarPorMinPaginas(int paginas) {
        return libroService.buscarPorMinPaginas(paginas);
    }
}
