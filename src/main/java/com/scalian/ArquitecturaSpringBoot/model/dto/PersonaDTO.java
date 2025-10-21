package com.scalian.ArquitecturaSpringBoot.model.dto;

import lombok.Data;

@Data
public class PersonaDTO {
    //No queremos que muestre el campo ID.
    private String nombre;
    private int edad;
}
