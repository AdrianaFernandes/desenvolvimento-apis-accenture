package com.example.apis.controller.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.example.apis.model.Cliente;

public class ClienteDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private LocalDateTime dataCadastro;
	private String nome;
	private String cpfCnpj;
	private String logradouro;
	private String cidade;
	private String uf;
	private String cep;
	private String telefone;
	private String email;

	public ClienteDto(Cliente cliente) {

		this.id = cliente.getId();
		this.dataCadastro = cliente.getDataCadastro();
		this.nome = cliente.getNome();
		this.cpfCnpj = cliente.getCpfCnpj();
		this.logradouro = cliente.getLogradouro();
		this.cidade = cliente.getCidade();
		this.uf = cliente.getUf();
		this.cep = cliente.getCep();
		this.telefone = cliente.getTelefone();
		this.email = cliente.getEmail();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public String getNome() {
		return nome;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getUf() {
		return uf;
	}

	public String getCep() {
		return cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public static List<ClienteDto> converter(List<Cliente> clientes) {
		return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
	}

}
