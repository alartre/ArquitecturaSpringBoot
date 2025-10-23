package com.scalian.ArquitecturaSpringBoot.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibroDTO {
    /**
     * id (Long, autogenerado)
     * titulo (String, obligatorio)
     * autor (String, obligatorio)
     * paginas (int, mínimo 1)
     */

    private String titulo;
    private String autor;
    private int paginas;
}
