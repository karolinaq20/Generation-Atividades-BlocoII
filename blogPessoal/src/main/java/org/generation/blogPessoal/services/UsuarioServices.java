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
	/**
	 * Utilizada para atualizar os campos de Nome e senha do usuario
	 * @param idUsuario - Long idUsuario
	 * @param atualizacaoUsuario - Entidade Usuario
	 * @author Karolina
	 * @since 1.0
	 * @return Retorna um Optional com entidade Usuario caso o mesmo exista.Do contrario um Optional vazio.
	 */
	public Optional<Usuario> atualizarUsuario(Long idUsuario,Usuario atualizacaoUsuario){
		Optional<Usuario> usuarioExistente = repository.findById(idUsuario);
	
		if (usuarioExistente.isPresent()) {
			usuarioExistente.get().setNome(atualizacaoUsuario.getNome());
			usuarioExistente.get().setSenha(atualizacaoUsuario.getSenha());
			return Optional.ofNullable(repository.save(usuarioExistente.get()));
		}else {
			return Optional.empty();
		}

	}
	

}
