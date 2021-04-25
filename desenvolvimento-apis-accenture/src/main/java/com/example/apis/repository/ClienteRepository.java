package com.example.apis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apis.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	List<Cliente> findByNome(String nome);
	
	List<Cliente> findByCpfCnpj(String cpfCnpj);
	
	List<Cliente> findByCidade(String cidade);
	
	List<Cliente> findByUf(String uf);
	
}
