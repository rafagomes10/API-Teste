package br.com.residencia.reactnative.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ped_cd_id")
	private Integer id;
	
	@Column(name = "ped_int_numpedido")
	private Integer numeoPedido;
	
	@Column(name = "ped_nu_precototal")
	private BigDecimal precoTotal;

	@Column(name = "ped_dt_hr_compra")
	private LocalDate dtHrCompra;
	
	@ManyToOne
	@JoinColumn(name = "fk_usu_cd_id", referencedColumnName = "usu_cd_id")
	private Usuario usuario;

	public Pedido() {
		super();
	}

	public Pedido(Integer id, Integer numeoPedido, BigDecimal precoTotal, LocalDate dtHrCompra, Usuario usuario) {
		super();
		this.id = id;
		this.numeoPedido = numeoPedido;
		this.precoTotal = precoTotal;
		this.dtHrCompra = dtHrCompra;
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumeoPedido() {
		return numeoPedido;
	}

	public void setNumeoPedido(Integer numeoPedido) {
		this.numeoPedido = numeoPedido;
	}

	public BigDecimal getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(BigDecimal precoTotal) {
		this.precoTotal = precoTotal;
	}

	public LocalDate getDtHrCompra() {
		return dtHrCompra;
	}

	public void setDtHrCompra(LocalDate dtHrCompra) {
		this.dtHrCompra = dtHrCompra;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
