package com.example.apis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apis.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	List<Usuario> findByNome(String nome);

	List<Usuario> findByEmail(String email);

}
