package com.example.apis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apis.model.Cliente;
import com.example.apis.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {	

	//quando crio uma class começa com letra maiuscula e quando cria um objeto com letra minuscula
	
	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping //busca todos os clientes
	public List<Cliente> listarClientes(){
		List<Cliente> clientes = clienteRepository.findAll();
		return clientes;
		
	}
	
	@PostMapping //Incluir novo cliente
	public Cliente criarClientes(@RequestBody Cliente clientes){		
		return clienteRepository.save(clientes);
	}
	
	@GetMapping ("/{id}") //Buscar um cliente pelo ID.
	public Cliente buscaClientePorId(@PathVariable Long id)  {
		return clienteRepository.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	 public void excluirCliente(@PathVariable Long id) {
		clienteRepository.deleteById(id);
	 }
	
		
	
}
