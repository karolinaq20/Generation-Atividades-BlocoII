package org.generation.blogPessoal.services;

import java.util.Optional;

import org.generation.blogPessoal.Repository.PostagemRepository;
import org.generation.blogPessoal.Repository.UsuarioRepository;
import org.generation.blogPessoal.model.Postagem;
import org.generation.blogPessoal.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServices {

	private @Autowired UsuarioRepository repository;
	private @Autowired PostagemRepository repositoryP;
	/**
	 * Metodo Utilizado para cadastrar um usuario no sistema,validando sua existência.
	 * @param novoUsuario
	 * @since 1.0
	 * @return Optional com entidade Usuario dentro ou Optional vazio.
	 */
	
	public Optional<Usuario> cadastrarUsuario(Usuario novoUsuario){
		Optional<Usuario> usuarioExistente = repository.findByUsuario(novoUsuario.getUsuario());

		if (usuarioExistente.isPresent()) {
			return Optional.empty();
		} else {
			return Optional.ofNullable(repository.save(novoUsuario));
		}
		
	}
public Optional<Postagem> criarPostagem(Long idUsuario,Postagem novaPostagem){
	Optional<Usuario> usuarioExistente = repository.findById(idUsuario);
	
	if (usuarioExistente.isPresent()) {
		novaPostagem.setCriador(usuarioExistente.get());
		return Optional.ofNullable(repositoryP.save(novaPostagem));
	}else {
		return Optional.empty();
	}
}

}
