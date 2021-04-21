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
import com.example.apis.model.Usuario;
import com.example.apis.repository.ClienteRepository;
import com.example.apis.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping //busca todos os clientes
	public List<Usuario> listarUsuario(){
		List<Usuario> usuarios = usuarioRepository.findAll();
		return usuarios;
		
	}
	
	@PostMapping //Incluir novo cliente
	public Usuario criarUsuario(@RequestBody Usuario usuarios){		
		return usuarioRepository.save(usuarios);
	}
	
	@GetMapping ("/{id}") //Buscar um cliente pelo ID.
	public Usuario buscaUsuarioPorId(@PathVariable Long id){
		return usuarioRepository.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	 public void excluirUsuario(@PathVariable Long id) {
		usuarioRepository.deleteById(id);
	 }
	
}
