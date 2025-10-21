package com.scalian.ArquitecturaSpringBoot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {

    @GetMapping("/ping")
    public String ping() {
        return "Hola desde Spring Boot";
    }
}
