package org.generation.blogPessoal.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Postagem")
public class Postagem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Size(min = 5, max = 100)
	private String titulo;
	@NotNull
	@Size(min = 5, max = 500)
	private String texto;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date = new java.sql.Date(System.currentTimeMillis());
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")//Professor Plataforma 
	private Tema tema;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
	@JoinColumn(name = "usuario_id")//Professor Plataforma 
	private Usuario criador;
	
	@ManyToMany
	@JoinTable(
			name = "relacaoTP",
			joinColumns = @JoinColumn(name = "fk_postagens"),
			inverseJoinColumns = @JoinColumn(name = "fk_tema")) // Feito pelo professor Boaz 
	
	private List<Tema> temasRelacionados = new ArrayList<>();	
	
	
	public List<Tema> getTemasRelacionados() {
		return temasRelacionados;
	}

	public void setTemasRelacionados(List<Tema> temasRelacionados) {
		this.temasRelacionados = temasRelacionados;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getCriador() {
		return criador;
	}

	public void setCriador(Usuario criador) {
		this.criador = criador;
	}

}
