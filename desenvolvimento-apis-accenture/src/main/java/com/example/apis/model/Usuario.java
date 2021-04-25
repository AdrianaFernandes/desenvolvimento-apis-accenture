package com.example.apis.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.apis.enums.Perfil;
import com.example.apis.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name="TB_USUARIO")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long id;		
	
	private LocalDateTime dataCadastro = LocalDateTime.now();
	
	@Column(name="nome", length=30, nullable=false, unique=false)
	private String nome;
	
	@Column(name="login", length=15, nullable=false, unique=true)
	private String login;
	
	@Column(name="senha", length=10, nullable=false, unique=false)
	private String senha;
	
	@Column(name="telefone", length=11, unique=false)
	private String telefone;
	
	@Column(name="email", length=100, unique=false)
	private String email;
	
	@Enumerated(EnumType.STRING) //informa qual tipo de enum
	@Column(name="perfil", length=1, nullable=false, unique=false)
	private Perfil perfil;
	
	@Column(name="status", length=1, nullable=false, unique=false)
	private Status status;
	
	public Usuario(String nome, String login, String senha, String telefone, String email) {
	}	

	public Usuario(String nome, String login, String senha, String telefone, String email, Perfil perfil,
			Status status) {
		
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.telefone = telefone;
		this.email = email;
		this.perfil = perfil;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	
	
}
