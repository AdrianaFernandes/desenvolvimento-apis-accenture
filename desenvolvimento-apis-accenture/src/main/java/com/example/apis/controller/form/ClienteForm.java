package com.example.apis.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.apis.model.Cliente;

public class ClienteForm {

	@NotNull
	@NotEmpty
	@Size(max = 30)
	private String nome;

	@NotNull
	@NotEmpty
	@Size(max = 14)
	private String cpfCnpj;

	@NotNull
	@NotEmpty
	@Size(max = 50)
	private String logradouro;

	@NotNull
	@NotEmpty
	@Size(max = 40)
	private String cidade;

	@NotNull
	@NotEmpty
	@Size(min = 2, max = 2)
	private String uf;

	@NotNull
	@NotEmpty
	@Size(min = 8, max = 8)
	private String cep;

	@Size(min = 11, max = 11)
	private String telefone;

	@Size(max = 100)
	private String email;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.toUpperCase().trim();
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj.toUpperCase().trim();
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro.toUpperCase().trim();
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade.toUpperCase().trim();
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf.toUpperCase().trim();
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep.toUpperCase().trim();
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone.toUpperCase().trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.toUpperCase().trim();
	}

	public Cliente converter() {
		return new Cliente(nome, cpfCnpj, logradouro, cidade, uf, cep, telefone, email);
	}

}
