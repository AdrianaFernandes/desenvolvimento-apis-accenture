package com.example.apis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apis.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
