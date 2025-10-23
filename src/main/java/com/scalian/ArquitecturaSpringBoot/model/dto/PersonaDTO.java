package com.scalian.ArquitecturaSpringBoot.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO {
    //No queremos que muestre el campo ID.
    private String nombre;
    private int edad;

}
