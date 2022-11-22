package br.com.residencia.reactnative.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cat_cd_id")
	private Integer id;
	
	@Column(name = "cat_tx_nome")
	private String nome;
	
	@Column(name = "cat_tx_foto", columnDefinition="TEXT")
	private String foto;
	
	public Categoria() {
		super();
	}

	public Categoria(Integer id, String nome, String foto) {
		super();
		this.id = id;
		this.nome = nome;
		this.foto = foto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
}
