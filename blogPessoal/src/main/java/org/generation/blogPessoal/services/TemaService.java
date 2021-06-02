package org.generation.blogPessoal.services;

import java.util.Optional;

import org.generation.blogPessoal.Repository.TemaRepository;
import org.generation.blogPessoal.model.Tema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemaService {

	private @Autowired TemaRepository repository;
	/*
	 * Metodo utilizado para criar um 
	 * @param novoTema
	 * @return
	 */
	
	
	/*public Optional<Object>cadastrarTema(Tema novoTema){
		return repository.findByTema(novoTema.getTema())
				.map(temaExistente -> Optional.empty())
				.orElse(Optional.ofNullable(repository.save(novoTema)));*/
	}

