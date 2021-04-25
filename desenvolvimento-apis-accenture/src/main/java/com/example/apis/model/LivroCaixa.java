package com.example.apis.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.apis.enums.FormaPagto;


@Entity
@Table(name="TB_LIVROCAIXA")
public class LivroCaixa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //gera os numeros dos Id automatico
	private Long id;
	
	@ManyToOne //muito registro para um cliente	
	private Cliente cliente;	
	
	private LocalDateTime dataLancamento = LocalDateTime.now();
	
	@Column(name="descricao", length=50, nullable=false, unique=false)
	private String descricao;
	
	@Enumerated(EnumType.STRING) //informa qual tipo de enum
	@Column(name="tipo", length=1, nullable=false, unique=false)
	private FormaPagto tipo;
	
	@Column(name="valor", columnDefinition="Decimal(12,2)", nullable=false)
	private BigDecimal valor;
	

	public LivroCaixa(String descricao, FormaPagto tipo, BigDecimal valor) {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDateTime getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDateTime dataLancamento) {
		this.dataLancamento = dataLancamento;
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

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	
	
}
