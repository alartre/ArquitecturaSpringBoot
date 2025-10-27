package com.scalian.ArquitecturaSpringBoot.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibroDTO {
    //No queremos que muestre el campo ID.
    private String titulo;
    private String autor;
    private int paginas;

}
