package com.example.apis.controller.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.example.apis.enums.FormaPagto;
import com.example.apis.model.LivroCaixa;

public class LivroCaixaDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String descricao;
	private FormaPagto tipo;
	private Long idCliente;
	private String nomeCliente;
	private BigDecimal valor;

	public LivroCaixaDto(LivroCaixa livroCaixa) {

		this.id = livroCaixa.getId();
		this.descricao = livroCaixa.getDescricao();
		this.tipo = livroCaixa.getTipo();
		this.idCliente = livroCaixa.getCliente().getId();
		this.nomeCliente = livroCaixa.getCliente().getNome();
		this.valor = livroCaixa.getValor();

	}

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

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static List<LivroCaixaDto> converter(List<LivroCaixa> livroCaixa) {
		return livroCaixa.stream().map(LivroCaixaDto::new).collect(Collectors.toList());
	}

}
