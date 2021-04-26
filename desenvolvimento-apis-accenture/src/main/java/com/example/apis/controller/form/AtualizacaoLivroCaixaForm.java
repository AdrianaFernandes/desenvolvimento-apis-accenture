package com.example.apis.controller.form;

import java.math.BigDecimal;
import java.util.Optional;

import com.example.apis.enums.FormaPagto;
import com.example.apis.model.Cliente;
import com.example.apis.model.LivroCaixa;
import com.example.apis.repository.LivroCaixaRepository;

public class AtualizacaoLivroCaixaForm {

	private String descricao;
	
	private FormaPagto tipo;
	
	private BigDecimal valor;	
	
	private Cliente cliente;	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public FormaPagto getTipo() {
		return tipo;
	}

	public void setTipo(FormaPagto tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	

//	public LivroCaixa atualizar(Long id, LivroCaixaRepository livroCaixaRepository) {
//
//		LivroCaixa livroCaixa = livroCaixaRepository.getOne(id);
//
//		if (this.descricao != null)
//			livroCaixa.setDescricao(this.descricao);
//
//		if (this.tipo != null)
//			livroCaixa.setTipo(this.tipo);
//
//		if (this.valor != null)
//			livroCaixa.setValor(this.valor);
//		
//		return livroCaixa;
//	}


	public LivroCaixa atualizar(Long id, LivroCaixaRepository livroCaixaRepository) {

		Optional<LivroCaixa> user = livroCaixaRepository.findById(id);

		if (user.isPresent()) {

			LivroCaixa livroCaixa = user.get();

			livroCaixa.setDescricao(this.descricao);

			livroCaixa.setTipo(this.tipo);

			livroCaixa.setValor(this.valor);	
			
			livroCaixa.setCliente(this.cliente);
			
			return livroCaixa;
		} else {
			return null;
		}
	}
	
}
