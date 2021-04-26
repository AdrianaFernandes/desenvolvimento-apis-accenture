package com.example.apis.enums;

public enum FormaPagto {
	
	D("Débito"),
	C("Crédito");
	
	private String tipo;	

	FormaPagto (String tipo){
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}

	public String setTipo() {
		return tipo;
	}
}
