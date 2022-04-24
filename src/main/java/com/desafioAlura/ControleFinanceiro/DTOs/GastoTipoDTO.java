package com.desafioAlura.ControleFinanceiro.DTOs;

import java.math.BigDecimal;

import com.desafioAlura.ControleFinanceiro.models.enums.Tipo;

public class GastoTipoDTO {

	private Tipo tipo;

	private BigDecimal valor_total;

	public GastoTipoDTO() {
		super();

	}

	public GastoTipoDTO(Tipo tipo, BigDecimal valor_total) {
		super();
		this.tipo = tipo;
		this.valor_total = valor_total;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getValor_total() {
		return valor_total;
	}

	public void setValor_total(BigDecimal valor_total) {
		this.valor_total = valor_total;
	}

}