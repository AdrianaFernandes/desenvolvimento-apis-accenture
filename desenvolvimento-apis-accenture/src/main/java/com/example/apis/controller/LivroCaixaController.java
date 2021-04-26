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

import com.example.apis.controller.dto.LivroCaixaDto;
import com.example.apis.controller.form.AtualizacaoLivroCaixaForm;
import com.example.apis.model.LivroCaixa;
import com.example.apis.repository.LivroCaixaRepository;

@RestController
@RequestMapping("/livrocaixa")
public class LivroCaixaController {

	@Autowired
	private LivroCaixaRepository livroCaixaRepository;

	@GetMapping
	public List<LivroCaixaDto> listaLivroCaixa(String descricao, String tipo, String valor, Long idCliente) {

		List<LivroCaixa> livrocaixas = livroCaixaRepository.findAll();

		if (descricao != null) {
			livrocaixas = livroCaixaRepository.findByDescricao(descricao);

		}
		if (tipo != null) {
			livrocaixas = livroCaixaRepository.findByTipo(tipo);

		}
		if (valor != null) {
			livrocaixas = livroCaixaRepository.findByValor(valor);
		}
		
		if (idCliente != null) {
			livrocaixas = livroCaixaRepository.findByClienteId(idCliente);
		}		

		return LivroCaixaDto.converter(livrocaixas);
	}

	@GetMapping("/{id}")
	public LivroCaixaDto detalhar(@PathVariable Long id) {

		LivroCaixa livrocaixas = livroCaixaRepository.getOne(id);
		return new LivroCaixaDto(livrocaixas);
	}

	@PostMapping
//	public ResponseEntity<LivroCaixaDto> cadastrar(@RequestBody @Valid LivroCaixaForm form, UriComponentsBuilder uriBuilder) {
//
//		LivroCaixa livrocaixas = form.converter();
//		livroCaixaRepository.save(livrocaixas);
//
//		URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(livrocaixas.getId()).toUri();
//		return ResponseEntity.created(uri).body(new LivroCaixaDto(livrocaixas));
//	}

	public ResponseEntity<LivroCaixa> cadastrar(@RequestBody @Valid LivroCaixa form, UriComponentsBuilder uriBuilder) {	
		
		livroCaixaRepository.save(form);
		URI uri = uriBuilder.path("/livroCaixa/{id}").buildAndExpand(form.getId()).toUri();
		return ResponseEntity.created(uri).body(form);
	}

	@PutMapping("/{id}")
	@Transactional // valida a operação no banco de dados
	public ResponseEntity<LivroCaixaDto> atualizar(@PathVariable Long id,
			@RequestBody @Valid AtualizacaoLivroCaixaForm form) {

		LivroCaixa dadosAtualizados = form.atualizar(id, livroCaixaRepository);

		return ResponseEntity.ok(new LivroCaixaDto(dadosAtualizados));
	}

	@DeleteMapping("/{id}")
	@Transactional // valida a operação no banco de dados
	public ResponseEntity<?> deletaLivroCaixa(@PathVariable Long id) {
		livroCaixaRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
