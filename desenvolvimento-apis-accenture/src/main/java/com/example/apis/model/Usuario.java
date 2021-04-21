package com.example.apis.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.apis.enums.Perfil;
import com.example.apis.enums.Status;

import lombok.Data;

@Data
@Entity
@Table(name="TB_USUARIO")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long id;		
	
	private LocalDateTime dataCadastro = LocalDateTime.now();
	
	@Column(name="nome", length=30, nullable=false, unique=false)
	private String nome;
	
	@Column(name="login", length=15, nullable=false, unique=true)
	private String login;
	
	@Column(name="senha", length=10, nullable=false, unique=false)
	private String senha;
	
	@Column(name="telefone", length=11, unique=false)
	private String telefone;
	
	@Column(name="email", length=100, unique=false)
	private String email;
	
	@Enumerated(EnumType.STRING) //informa qual tipo de enum
	@Column(name="perfil", length=1, nullable=false, unique=false)
	private Perfil perfil;
	
	@Column(name="status", length=1, nullable=false, unique=false)
	private Status status;
	
}
