package com.example.apis.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.apis.model.Usuario;

public class UsuarioForm {


	@Size(max = 30)
	private String nome;	
	
	@Size(max = 15)
	private String login;
	
	@Size(max = 10)
	private String senha;

	@Size(min = 11, max = 11)
	private String telefone;

	@Size(max = 100)
	private String email;

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
		
	public Usuario converter() {
		return new Usuario(nome, login, senha, telefone, email);
	}

}
