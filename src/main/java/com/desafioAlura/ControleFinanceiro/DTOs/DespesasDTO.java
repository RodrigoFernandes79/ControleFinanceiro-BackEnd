package com.desafioAlura.ControleFinanceiro.DTOs;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DespesasDTO {

	@NotNull(message = "Campo Obrigatório!")
    @JsonFormat(pattern="MM")
	private LocalDate dataPagamento;

	private BigDecimal total_Despesas;

	public DespesasDTO() {

	}

	public DespesasDTO(LocalDate dataPagamento, BigDecimal total_Despesas) {
		super();
		this.dataPagamento = dataPagamento;
		this.total_Despesas = total_Despesas;
	}

	public int getDataPagamento() {
		return dataPagamento.getMonthValue();
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public BigDecimal getTotal_Despesas() {
		return total_Despesas;
	}

	public void setTotal_Despesas(BigDecimal total_Despesas) {
		this.total_Despesas = total_Despesas;
	}

	

}