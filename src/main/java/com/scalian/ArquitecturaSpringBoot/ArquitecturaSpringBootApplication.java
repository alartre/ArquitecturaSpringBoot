package com.scalian.ArquitecturaSpringBoot;

import com.scalian.ArquitecturaSpringBoot.model.entity.Persona;
import com.scalian.ArquitecturaSpringBoot.repository.PersonaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ArquitecturaSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArquitecturaSpringBootApplication.class, args);
	}

    @Bean
    public CommandLineRunner init(PersonaRepository repositorio) {
        return args -> {
            repositorio.save(new Persona(null, "Álvaro", 30));
            repositorio.save(new Persona(null, "Lucía", 25));
        };
    }


}
