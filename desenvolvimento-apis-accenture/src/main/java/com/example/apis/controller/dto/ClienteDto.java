package com.example.apis.controller.dto;


import java.util.List;
import java.util.stream.Collectors;

import com.example.apis.enums.Status;
import com.example.apis.model.Cliente;

public class ClienteDto  {	
	

	
	private Long id;	
	private String nome;
	private String cpfCnpj;	
	private String telefone;
	
	//sempre que for um metodo abrir e fechar parenteses
	public ClienteDto(Cliente cliente){
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.cpfCnpj = cliente.getCpfCnpj();
		this.telefone = cliente.getTelefone();			
	}
	
	public static List<ClienteDto> converter(List<Cliente> clientes){
		return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
	}
	
}
