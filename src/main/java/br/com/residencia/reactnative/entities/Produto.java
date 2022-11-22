package br.com.residencia.reactnative.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pro_cd_id")
	private Integer id;
	
	@Column(name = "pro_tx_nome")
	private String nome;
	
	@Column(name = "pro_tx_descricao")
	private String descricao;
	
	@Column(name = "pro_int_qtdestoque")
	private Integer qtdEstoque;
	
	@Column(name = "pro_nu_preco")
	private BigDecimal preco;
	
	@Column(name = "pro_tx_foto")
	private String foto;
	
	@ManyToOne
	@JoinColumn(name = "fk_cat_cd_id", referencedColumnName = "cat_cd_id")
	private Categoria categoria;

	public Produto() {
		super();
	}

	public Produto(Integer id, String nome, String descricao, Integer qtdEstoque, BigDecimal preco, String foto,
			Categoria categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.qtdEstoque = qtdEstoque;
		this.preco = preco;
		this.foto = foto;
		this.categoria = categoria;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
