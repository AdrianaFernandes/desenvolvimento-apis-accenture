package com.example.apis.controller.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import com.example.apis.model.Usuario;

public class UsuarioDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private String login;
	private String senha;
	private String email;

	public UsuarioDto(Usuario usuario) {

		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.login = usuario.getLogin();
		this.senha = usuario.getSenha();
		this.email = usuario.getEmail();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}
	
	public String getEmail() {
		return email;
	}
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public static List<UsuarioDto> converter(List<Usuario> usuario) {
		return usuario.stream().map(UsuarioDto::new).collect(Collectors.toList());
	}

}
