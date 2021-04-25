package com.example.apis.enums;

public enum Status {
	A("Ativo"), C("Cancelado");

	private String tipo;

	Status(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

//	public static TipoStatus toEnum(String tipo) {
//		if (tipo == null) {
//			return null;
//		}
//		for (TipoStatus x : TipoStatus.values()) {
//			if (tipo.equals(x.getDescricao())) {
//				return x;
//			}
//		}
//		throw new IllegalArgumentException("Acesso inválido");
//	}
}
