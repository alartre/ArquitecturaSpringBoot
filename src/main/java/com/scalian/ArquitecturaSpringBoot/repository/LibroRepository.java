package com.scalian.ArquitecturaSpringBoot.repository;

import com.scalian.ArquitecturaSpringBoot.model.entity.Libro;
import com.scalian.ArquitecturaSpringBoot.model.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByPaginasGreaterThan(int paginas);

    //JPQL
    @Query("SELECT l FROM Libro l WHERE LOWER(l.autor) LIKE LOWER(CONCAT('%', :filtro, '%'))")
    List<Libro> buscarPorAutor(@Param("filtro") String filtro);
}
