package com.desafioAlura.ControleFinanceiro.models.enums;

public enum Tipo {
	
	FIXA(0,"FIXA"),
	VARIAVEL(1,"VARIAVEL");
	
	
	private Integer cod;
	private String descricao;
	
	
	private Tipo(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}


	public Integer getCod() {
		return cod;
	}


	public String getDescricao() {
		return descricao;
	}
	
	public static Tipo toEnum(Integer cod) {
		if(cod == null) {
			return null;
		} for (Tipo x: Tipo.values()) {
			if(cod==x.getCod()) {
				return x;
			}
		} throw new IllegalArgumentException("Código Status Inválido "+ cod + "!");
	}

}
