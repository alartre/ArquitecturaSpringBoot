package com.scalian.ArquitecturaSpringBoot.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "El título es obligatorio")
    private String titulo;

    @NotBlank(message = "El autor es obligatorio")
    private String autor;

    @NotNull(message = "El número de páginas es obligatorio")
    @Min(value = 1, message = "El libro debe tener al menos 1 página")
    private Integer paginas;
}
