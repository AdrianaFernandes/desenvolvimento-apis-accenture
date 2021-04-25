package com.example.apis.controller.form;

import java.math.BigDecimal;

import javax.validation.constraints.Size;

import com.example.apis.enums.FormaPagto;
import com.example.apis.model.LivroCaixa;
import com.example.apis.repository.LivroCaixaRepository;

public class AtualizacaoLivroCaixaForm {

	@Size(max = 30)
	private String descricao;
	
	@Size(min=1, max=1)
	private FormaPagto tipo;
	
	@Size
	private BigDecimal valor;	

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

	public LivroCaixa atualizar(Long id, LivroCaixaRepository livroCaixaRepository) {

		LivroCaixa livroCaixa = livroCaixaRepository.getOne(id);

		if (this.descricao != null)
			livroCaixa.setDescricao(this.descricao);

		if (this.tipo != null)
			livroCaixa.setTipo(this.tipo);

		if (this.valor != null)
			livroCaixa.setValor(this.valor);
		
		return livroCaixa;
	}

}
