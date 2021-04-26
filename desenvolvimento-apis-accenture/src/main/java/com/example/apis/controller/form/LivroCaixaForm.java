package com.example.apis.controller.form;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.apis.enums.FormaPagto;
import com.example.apis.model.LivroCaixa;
import com.example.apis.model.Usuario;

public class LivroCaixaForm {

	
	private String descricao;	
	
	private FormaPagto tipo;
	
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

	public LivroCaixa converter() {
		return new LivroCaixa(descricao, tipo, valor);
	}

}
