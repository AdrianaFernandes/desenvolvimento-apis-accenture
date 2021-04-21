package com.example.apis.model;

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

import com.example.apis.enums.FormaPagto;

import lombok.Data;

@Data
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
	private double valor;
	
}
