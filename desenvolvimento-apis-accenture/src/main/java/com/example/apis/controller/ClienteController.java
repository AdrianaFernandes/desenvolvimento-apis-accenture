package com.example.apis.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.apis.controller.dto.ClienteDto;
import com.example.apis.controller.form.AtualizacaoClienteForm;
import com.example.apis.controller.form.ClienteForm;
import com.example.apis.model.Cliente;
import com.example.apis.repository.ClienteRepository;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

	// quando crio uma class começa com letra maiuscula e quando cria um objeto com
	// letra minuscula

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping
	public List<ClienteDto> listaClientes(String nome, String cpfCnpj, String cidade, String uf) {

		List<Cliente> clientes = clienteRepository.findAll();

		if (nome != null) {
			clientes = clienteRepository.findByNome(nome.toUpperCase().trim());

		}
		if (cpfCnpj != null) {
			clientes = clienteRepository.findByCpfCnpj(cpfCnpj.trim());

		}
		if (cidade != null) {
			clientes = clienteRepository.findByCidade(cidade.toUpperCase().trim());

		}
		if (uf != null) {
			clientes = clienteRepository.findByUf(uf.toUpperCase().trim());

		}

		return ClienteDto.converter(clientes);
	}

	@GetMapping("/{id}")
	public ClienteDto detalhar(@PathVariable Long id) {

		Cliente cliente = clienteRepository.getOne(id);
		return new ClienteDto(cliente);
	}

	@PostMapping
	public ResponseEntity<ClienteDto> cadastrar(@RequestBody @Valid ClienteForm form, UriComponentsBuilder uriBuilder) {

		Cliente cliente = form.converter();
		clienteRepository.save(cliente);

		URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDto(cliente));
	}

	@PutMapping("/{id}")
	@Transactional //valida a operação no banco de dados
	public ResponseEntity<ClienteDto> atualizar(@PathVariable Long id,
			@RequestBody @Valid AtualizacaoClienteForm form) {

		Cliente dadosAtualizados = form.atualizar(id, clienteRepository);

		return ResponseEntity.ok(new ClienteDto(dadosAtualizados));
	}

	@DeleteMapping("/{id}")
	@Transactional //valida a operação no banco de dados
	public ResponseEntity<?> deletaCliente(@PathVariable Long id) {
		clienteRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
