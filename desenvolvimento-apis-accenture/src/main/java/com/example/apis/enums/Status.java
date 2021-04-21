package com.example.apis.enums;


public enum Status {
	A("Ativo"), 
	C("Cancelado");
	
	private String tipo;
	
	Status (String tipo){
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	
}
