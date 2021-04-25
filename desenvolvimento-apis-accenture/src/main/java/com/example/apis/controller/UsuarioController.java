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

import com.example.apis.controller.dto.UsuarioDto;
import com.example.apis.controller.form.AtualizacaoUsuarioForm;
import com.example.apis.controller.form.UsuarioForm;
import com.example.apis.model.Usuario;
import com.example.apis.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping // busca todos os clientes
	public List<UsuarioDto> listaUsuarios(String nome, String email) {

		List<Usuario> usuario = null;

		if (nome != null) {
			usuario = usuarioRepository.findByNome(nome);
			return UsuarioDto.converter(usuario);

		} else if (email != null) {
			usuario = usuarioRepository.findByEmail(email);
			return UsuarioDto.converter(usuario);

		} else {
			usuario = usuarioRepository.findAll();
			return UsuarioDto.converter(usuario);
		}
	}

	@GetMapping("/{id}") // busca so pelo ids
	public UsuarioDto detalhar(@PathVariable Long id) {

		Usuario usuario = usuarioRepository.getOne(id);
		return new UsuarioDto(usuario);
	}

	@PostMapping // caastra usuario
	public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid UsuarioForm form, UriComponentsBuilder uriBuilder) {
		Usuario usuario = form.converter();
		usuarioRepository.save(usuario);

		URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(new UsuarioDto(usuario));
	}

	@PutMapping("/{id}") // atualiza usuario
	@Transactional // valida a operação no banco de dados
	public ResponseEntity<UsuarioDto> atualizar(@PathVariable Long id,
			@RequestBody @Valid AtualizacaoUsuarioForm form) {

		Usuario dadosAtualizados = form.atualizar(id, usuarioRepository);

		return ResponseEntity.ok(new UsuarioDto(dadosAtualizados));
	}

	@DeleteMapping("/{id}")
	@Transactional // valida a operação no banco de dados
	public ResponseEntity<?> deletaUsuario(@PathVariable Long id) {
		usuarioRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
