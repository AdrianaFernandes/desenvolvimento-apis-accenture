package com.example.apis.controller.form;

import javax.validation.constraints.Size;

import com.example.apis.model.Cliente;
import com.example.apis.repository.ClienteRepository;

public class AtualizacaoClienteForm {

	@Size(max = 30)
	private String nome;

	@Size(max = 50)
	private String logradouro;

	@Size(max = 40)
	private String cidade;

	@Size(min = 2, max = 2)
	private String uf;

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
		this.nome = nome;
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

	public Cliente atualizar(Long id, ClienteRepository clienteRepository) {

		Cliente cliente = clienteRepository.getOne(id);

		if (this.nome != null)
			cliente.setNome(this.nome);

		if (this.logradouro != null)
			cliente.setLogradouro(this.logradouro);

		if (this.cidade != null)
			cliente.setCidade(this.cidade);

		if (this.cep != null)
			cliente.setCep(this.cep);

		if (this.telefone != null)
			cliente.setTelefone(this.telefone);

		if (this.email != null)
			cliente.setEmail(this.email);

		return cliente;
	}

}
