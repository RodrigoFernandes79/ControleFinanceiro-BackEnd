package com.desafioAlura.ControleFinanceiro.models.enums;

public enum Categoria {
	
	ALIMENTACAO(0,"ALIMENTACAO"),
	SAUDE(1,"SAUDE"),
	MORADIA(2,"MORADIA"),
	TRANSPORTE(3,"TRANSPORTE"),
	EDUCACAO(4,"EDUCAÇÃO"),
	LAZER(5,"LAZER"),
	IMPREVISTOS(6,"IMPREVISTOS"),
	OUTRAS(7,"OUTRAS");
	
	private Integer cod;
	private String descricao;
	
	
	private Categoria(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}


	public Integer getCod() {
		return cod;
	}


	public String getDescricao() {
		return descricao;
	}
	
	public static Categoria toEnum(Integer cod) {
		if(cod == null) {
			return null;
		} for (Categoria x: Categoria.values()) {
			if(cod==x.getCod()) {
				return x;
			}
		} throw new IllegalArgumentException("Código Status Inválido "+ cod + "!");
	}

}
