package br.com.residencia.reactnative.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usu_cd_id")
	private Integer id;
	
	@Column(name = "usu_tx_nome")
	private String nome;
	
	@Column(name = "usu_tx_cpf")
	private String cpf;
	
	@Column(name = "usu_dt_dtnasc")
	private LocalDate dtNascimento;
	
	@Column(name = "usu_tx_login")
	private String login;
	
	@Column(name = "usu_bl_ativo")
	private Boolean ativo;
	
	@Column(name = "usu_tx_senha")
	private String senha;
	
	@Column(name = "usu_tx_foto")
	private String foto;

//	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
//	private List<Pedido> pedidos;
	
	public Usuario() {
		super();
	}

	public Usuario(Integer id, String nome, String cpf, LocalDate dtNascimento, String login, Boolean ativo,
			String senha, String foto) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dtNascimento = dtNascimento;
		this.login = login;
		this.ativo = ativo;
		this.senha = senha;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

}
