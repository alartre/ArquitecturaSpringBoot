package com.scalian.ArquitecturaSpringBoot.repository;


import com.scalian.ArquitecturaSpringBoot.model.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    //JPA
    List<Libro> buscarPorMinPaginas(int paginas);

    //JPQL
    @Query("SELECT l FROM Libro l WHERE LOWER(l.autor) LIKE LOWER(CONCAT('%', :autor, '%'))")
    List<Libro> buscarPorAutor(@Param("autor") String autor);
}
