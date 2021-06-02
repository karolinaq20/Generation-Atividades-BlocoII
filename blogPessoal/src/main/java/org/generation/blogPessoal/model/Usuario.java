package org.generation.blogPessoal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUsuario;
	private @NotNull (message ="Passar um valor aqui,não pode ser nulo.") String nome; //Escrever uma mensagem para o front end
	private @NotNull (message ="Passar um valor aqui,não pode ser nulo.")@Size(min = 3,max = 15,message = "Entre 3 a 15 Caracteres") String usuario;
	private @NotNull (message ="Passar um valor aqui,não pode ser nulo.") String senha;
	private boolean tipo;
	public boolean isTipo() {
		return tipo;
	}

	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}
	@OneToMany(mappedBy = "criador",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List <Postagem> minhasPostagens = new ArrayList<>();
	
	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
