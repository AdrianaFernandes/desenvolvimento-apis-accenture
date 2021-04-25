package com.example.apis.controller.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.example.apis.enums.FormaPagto;
import com.example.apis.model.LivroCaixa;

public class LivroCaixaDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String descricao;
	private FormaPagto tipo;
	private BigDecimal valor;

	public LivroCaixaDto(LivroCaixa livroCaixa) {

		this.descricao = livroCaixa.getDescricao();
		this.tipo = livroCaixa.getTipo();
		this.valor = livroCaixa.getValor();
		
	}
	
	public String getDescricao() {
		return descricao;
	}

	public FormaPagto getTipo() {
		return tipo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public static List<LivroCaixaDto> converter(List<LivroCaixa> livroCaixa) {
		return livroCaixa.stream().map(LivroCaixaDto::new).collect(Collectors.toList());
	}

}
