package com.example.apis.enums;

public enum Perfil {
		A("Administrador"),
		O("Operador");
		
		private String descricao;
		
		Perfil (String descricao){
			this.descricao = descricao;
		}

		public String getDescricao() {
			return descricao;
		}
}
