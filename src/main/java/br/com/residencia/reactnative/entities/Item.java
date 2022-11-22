package br.com.residencia.reactnative.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ite_cd_id")
	private Integer id;
	
	@Column(name = "ite_int_qtd")
	private Integer quantidade;
	
	@ManyToOne
	@JoinColumn(name = "fk_ped_cd_id", referencedColumnName = "ped_cd_id")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "fk_pro_cd_id", referencedColumnName = "pro_cd_id")
	private Produto produto;

	public Item() {
		super();
	}

	public Item(Integer quantidade, Pedido pedido, Produto produto) {
		super();
		this.quantidade = quantidade;
		this.pedido = pedido;
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
