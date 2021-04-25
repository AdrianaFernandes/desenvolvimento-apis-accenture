package com.example.autentificacaoJWT.config.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.apis.model.Usuario;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired //inicializa o objetos da class
	private Usuario userService;

	@Override //sobrescreve o metodo
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		com.bootstrap.springboot.model.User user = userService.getByLogin(login);

		if (user.getEmail().equals(login)) {
			return new User(login, user.getPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with login: " + login);
		}
	}
}