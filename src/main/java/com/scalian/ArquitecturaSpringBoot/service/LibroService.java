package com.scalian.ArquitecturaSpringBoot.service;

import com.scalian.ArquitecturaSpringBoot.model.dto.LibroDTO;
import com.scalian.ArquitecturaSpringBoot.model.entity.Libro;
import com.scalian.ArquitecturaSpringBoot.repository.LibroRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LibroService {
    /**
     * Libro:
     * id (Long, autogenerado)
     * titulo (String, obligatorio)
     * autor (String, obligatorio)
     * paginas (int, mínimo 1)
     */

    private final LibroRepository libroRepository;

    /**
     * Crear un libro
     * EndPoint: POST /apit/libros
     * libroService.crearLibro(libroDTO);
     * @return Libro
     */
    public Libro crearLibro(LibroDTO libroDTO) {
        Libro libro = new Libro(null, libroDTO.getTitulo(), libroDTO.getAutor(), libroDTO.getPaginas());
        return libroRepository.save(libro);
    }

//    /**
//     * Listar todos los libros
//     * Endpoint: GET /apit/libros
//     * libroService.listarLibros();
//     * @return
//     */
//    public List<LibroDTO> listarLibros() {
//        return libroRepository.findAll().stream()
//                .map(l -> {
//                    LibroDTO libroDTO = new LibroDTO();
//                    libroDTO.setTitulo(l.getTitulo());
//                    libroDTO.setAutor(l.getAutor());
//                    libroDTO.setPaginas(l.getPaginas());
//                    return libroDTO;
//                })
//                .collect(Collectors.toList());
//    }

    /**
     * Listar todos los libros
     * Endpoint: GET /apit/libros
     * libroService.listarLibros();
     * @return
     */
    public Page<LibroDTO> listarLibrosPaginado(Pageable pageable) {
        Page<Libro> librosPage = libroRepository.findAll(pageable);
        return librosPage.map(this::convertirADTO);
    }

//    /**
//     * Buscar libros por autor (contenga texto)
//     * Endpoint: GET /api/libros/buscar?autor=martin
//     * libroService.buscarPorAutor(autor);
//     * @param autor
//     * @return
//     */
//    public List<LibroDTO> buscarPorAutor(String autor) {
//        return libroRepository.buscarPorAutor(autor)
//                .stream()
//                .map(this::convertirADTO)
//                .toList();
//    }

    /**
     * Buscar libros por autor (contenga texto)
     * Endpoint: GET /api/libros/buscar?autor=martin
     * libroService.buscarPorAutor(autor);
     * @param autor
     * @param pageable
     * @return
     */
    public Page<LibroDTO> buscarPorAutorPaginado(String autor, Pageable pageable) {
        Page<Libro> librosPage = libroRepository.buscarPorAutor(autor, pageable);
        return librosPage.map(this::convertirADTO);
    }

    /**
     * Listar libros con más de X páginas
     * EndPoint: GET /api/libros/mayores?paginas=300
     * libroService.buscarPorMinPaginas(paginas);
     * @param paginas
     * @return
     */
    public List<LibroDTO> buscarPorMinPaginas(Integer paginas) {
        return libroRepository.findByPaginasGreaterThan(paginas).stream()
                .map(this::convertirADTO)
                .toList();
    }

    private LibroDTO convertirADTO(Libro libro) {
        return new LibroDTO(libro.getTitulo(), libro.getAutor(), libro.getPaginas());
    }
}
