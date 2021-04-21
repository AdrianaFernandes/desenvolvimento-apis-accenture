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

import com.example.apis.model.LivroCaixa;
import com.example.apis.model.Usuario;
import com.example.apis.repository.LivroCaixaRepository;
import com.example.apis.repository.UsuarioRepository;

@RestController
@RequestMapping("/LivroCaixa")
public class LivroCaixaController {


	@Autowired
	private LivroCaixaRepository livroCaixaRepository;
	
	@GetMapping //busca todos os clientes
	public List<LivroCaixa> listarLivroCaixa(){
		List<LivroCaixa> livrocaixas = livroCaixaRepository.findAll();
		return livrocaixas;
		
	}
	
	@PostMapping //Incluir novo cliente
	public LivroCaixa criarLivroCaixa(@RequestBody LivroCaixa livrocaixas){		
		return livroCaixaRepository.save(livrocaixas);
	}
	
	@GetMapping ("/{id}") //Buscar um cliente pelo ID.
	public LivroCaixa buscaLivroCaixaPorId(@PathVariable Long id){
		return livroCaixaRepository.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	 public void excluirLivroCaixa(@PathVariable Long id) {
		livroCaixaRepository.deleteById(id);
	 }
	
}
