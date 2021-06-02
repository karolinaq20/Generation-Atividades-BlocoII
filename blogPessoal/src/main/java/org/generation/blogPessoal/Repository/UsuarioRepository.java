package org.generation.blogPessoal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.generation.blogPessoal.model.Usuario;



	@Repository
	public interface UsuarioRepository extends JpaRepository <Usuario,Long>{
		
		Optional<Usuario> findByUsuario (String usuario);
		List<Usuario>findAllByNomeContaining(String nome);
	
	}
	

