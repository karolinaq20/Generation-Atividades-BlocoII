package org.generation.blogPessoal.controller;

import java.util.List;

import org.generation.blogPessoal.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.generation.blogPessoal.model.Usuario;
import org.generation.blogPessoal.services.UsuarioServices;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;
	private @Autowired UsuarioServices services;
	@GetMapping("/todes")
	public ResponseEntity<List<Usuario>> pegarTodes() {
		List<Usuario> listaDeUsuario = repository.findAll();
		if (!listaDeUsuario.isEmpty()) {
			return ResponseEntity.status(200).body(listaDeUsuario);

		} else {
			return ResponseEntity.status(204).build();
		}
	}

	@PostMapping("/salvar")
	public ResponseEntity <Usuario> salvarUsuario(@RequestBody Usuario novoUsuario) {
		return services.cadastrarUsuario(novoUsuario)
				.map(usuarioExistente -> ResponseEntity.status(201).body(usuarioExistente))
				.orElse(ResponseEntity.status(400).build());
		
	}
}
