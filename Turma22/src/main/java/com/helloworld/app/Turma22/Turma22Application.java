package com.helloworld.app.Turma22;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

@RestController
public class Turma22Application {
	@GetMapping("/rota")
	public ResponseEntity<String> mentalidadeHabilidade() {
		return ResponseEntity.status(200).body("A mentalidade que usamos nas aulas foi a atenção aos detalhes e a orientação ao futuro.");
	}
	@GetMapping("/rotadois")
	public ResponseEntity<String> objetivo() {
		return ResponseEntity.status(200).body("Pretendo aprender mais sobre Spring Boot , e ter mais atenção aos detalhes.");
	}
	public static void main(String[] args) {
		SpringApplication.run(Turma22Application.class, args);
	}

}
