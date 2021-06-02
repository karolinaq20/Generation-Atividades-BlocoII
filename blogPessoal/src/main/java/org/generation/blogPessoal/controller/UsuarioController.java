package org.generation.blogPessoal.controller;

import java.util.List;

import javax.validation.Valid;

import org.generation.blogPessoal.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<Usuario> salvarUsuario(@Valid @RequestBody Usuario novoUsuario) { // Colocar o @Valid para
																							// retornar um erro 400 e
																							// passar a mensagem.
		return services.cadastrarUsuario(novoUsuario)
				.map(usuarioExistente -> ResponseEntity.status(201).body(usuarioExistente))
				.orElse(ResponseEntity.status(400).build());

	}

	@GetMapping("/id/{id_usuario}")
	public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable(value = "id_usuario") Long idUsuario) {
		return repository.findById(idUsuario).map(usuarioExistente -> ResponseEntity.status(200).body(usuarioExistente))
				.orElse(ResponseEntity.status(204).build());
	}

	@GetMapping("/batatinha")
	public ResponseEntity<Object> buscarUsuarioPorNome(@RequestParam(defaultValue = "") String nome) {
		List<Usuario> listaDeUsuarios = repository.findAllByNomeContaining(nome);

		if (!listaDeUsuarios.isEmpty()) {
			return ResponseEntity.status(200).body(listaDeUsuarios);
		} else {
			return ResponseEntity.status(200).body("Não Existe!!!");
		}

	}

	@PutMapping("/atualizar/{id_usuario}") // PutMapping para fazer a atualização do usuario
	public ResponseEntity<Usuario> atualizarUsuario(@PathVariable(value = "id_usuario")Long idUsuario,@Valid @RequestBody Usuario atualizarUsuario) {
		return services.atualizarUsuario(idUsuario, atualizarUsuario)
		.map(usuarioAtualizado -> ResponseEntity.status(201).body(usuarioAtualizado))
		.orElse(ResponseEntity.status(304).build());
	}
	/*@DeleteMapping("/{id}") // Deletar um usuario
	public ResponseEntity<Usuario> deletarUsuario(@PathVariable(value = "id_usuario")Long idUsuario,@Valid @RequestBody Usuario deletarUsuario){*/
		
	}

