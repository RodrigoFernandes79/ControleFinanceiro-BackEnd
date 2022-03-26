package com.desafioAlura.ControleFinanceiro.DTOs;

import java.math.BigDecimal;

import com.desafioAlura.ControleFinanceiro.models.enums.Categoria;

public class GastoCategoriaDTO {

	private Categoria categoria;

	private BigDecimal valor_total;

	public GastoCategoriaDTO() {
		super();

	}

	public GastoCategoriaDTO(Categoria categoria, BigDecimal valor_total) {
		super();
		this.categoria = categoria;
		this.valor_total = valor_total;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public BigDecimal getValor_total() {
		return valor_total;
	}

	public void setValor_total(BigDecimal valor_total) {
		this.valor_total = valor_total;
	}

}