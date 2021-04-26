package com.example.apis.controller.form;

import java.util.Optional;

import javax.validation.constraints.Size;

import com.example.apis.model.Usuario;
import com.example.apis.repository.UsuarioRepository;


public class AtualizacaoUsuarioForm {

	@Size(max = 30)
	private String nome;

	@Size(max = 14)
	private String login;

	@Size(max = 50)
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

//	public Usuario atualizar(Long id, UsuarioRepository usuarioRepository) {
//
//		Usuario usuario = usuarioRepository.getOne(id);
//
//		if (this.nome != null)
//			usuario.setNome(this.nome);
//
//		if (this.login != null)
//			usuario.setLogin(this.login);
//
//		if (this.senha != null)
//			usuario.setSenha(this.senha);
//
//		if (this.telefone != null)
//			usuario.setTelefone(this.telefone);
//
//		if (this.email != null)
//			usuario.setEmail(this.email);
//
//		return usuario;
//	}

	public Usuario atualizar(Long id, UsuarioRepository usuarioRepository) {

		Optional<Usuario> user = usuarioRepository.findById(id);

		if (user.isPresent()) {

			Usuario usuario = user.get();

			usuario.setNome(this.nome);

			usuario.setLogin(this.login);

			usuario.setSenha(this.senha);

			usuario.setTelefone(this.telefone);
			usuario.setEmail(this.email);

			return usuario;
		} else {
			return null;
		}
	}

}
