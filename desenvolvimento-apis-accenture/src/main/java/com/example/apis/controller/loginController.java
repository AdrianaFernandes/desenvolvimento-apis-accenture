package com.example.apis.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.apis.enums.Status;
import com.example.apis.model.Usuario;
import com.example.apis.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/login")
public class loginController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@SuppressWarnings("unlikely-arg-type")
	@PostMapping
	public ResponseEntity<Usuario> login(@RequestParam (value = "login") String login, @RequestParam (value = "senha") String senha) {
		Optional<Usuario> logar = usuarioRepository.findByLogin(login);
		
		if (logar.isPresent()) {
			Usuario user = logar.get();
			
			if(!user.getSenha().equals(senha)) {
				return new ResponseEntity<Usuario>(HttpStatus.BAD_REQUEST);
			}
			
			if(user.getStatus().equals(Status.C.getTipo())){
				return new ResponseEntity<Usuario>(HttpStatus.BAD_REQUEST);
			}
			
			return ResponseEntity.ok(user);
			
		} else {
			return null;
		}
	}

}
