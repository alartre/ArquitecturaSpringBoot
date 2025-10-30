package com.scalian.ArquitecturaSpringBoot.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Libro {
    /**
     * id (Long, autogenerado)
     * titulo (String, obligatorio)
     * autor (String, obligatorio)
     * paginas (int, mínimo 1)
     */

    @Id
    @GeneratedValue
    private Long id;
    private String titulo;
    private String autor;
    private int paginas;


}
