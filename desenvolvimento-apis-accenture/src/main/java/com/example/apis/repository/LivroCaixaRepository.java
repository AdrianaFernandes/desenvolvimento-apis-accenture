package com.example.apis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apis.model.LivroCaixa;

public interface LivroCaixaRepository extends JpaRepository<LivroCaixa, Long>{
	
	List<LivroCaixa> findByDescricao(String descricao);

	List<LivroCaixa> findByTipo(String tipo);
	
	List<LivroCaixa> findByValor(String valor);

}
