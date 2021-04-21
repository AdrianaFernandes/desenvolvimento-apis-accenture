package com.example.apis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apis.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{	
	
}
