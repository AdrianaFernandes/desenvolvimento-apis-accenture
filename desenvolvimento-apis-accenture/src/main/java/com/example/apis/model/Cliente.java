package com.example.apis.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity // anotacao pra tabela
@Table(name = "TB_Cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDateTime dataCadastro = LocalDateTime.now();
	
	@Column(name="nome", length=30, nullable=false, unique=false)
	private String nome;
	
	@Column(name="cpfCnpj", length=14, nullable=false, unique=false)
	private String cpfCnpj;
	
	@Column(name="logradouro", length=50, nullable=false, unique=false)
	private String logradouro;
	
	@Column(name="cidade", length=40, nullable=false, unique=false)
	private String cidade;
	
	@Column(name="uf", length=2, nullable=false, unique=false)
	private String uf;
	
	@Column(name="cep", length=8, nullable=false, unique=false)
	private String cep;
	
	@Column(name="telefone", length=11, unique=false)
	private String telefone;
	
	@Column(name="email", length=100, unique=false)
	private String email;

	public Cliente() {

	}

	// não é feito um setId pois o mesmo é chave primario, não podendo alterar
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}