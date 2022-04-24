package com.desafioAlura.ControleFinanceiro.DTOs;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReceitasDTO {

	@NotNull(message = "Campo Obrigatório!")
	@JsonFormat(pattern = "MM")
	private LocalDate dataRecebimento;

	private BigDecimal total_Receitas;

	public ReceitasDTO() {

	}

	public ReceitasDTO(LocalDate dataRecebimento, BigDecimal total_Receitas) {
		super();
		this.dataRecebimento = dataRecebimento;
		this.total_Receitas = total_Receitas;
	}

	public int getDataRecebimento() {
		return dataRecebimento.getMonthValue();
	}

	public void setDataRecebimento(LocalDate dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	public BigDecimal getTotal_Receitas() {
		return total_Receitas;
	}

	public void setTotal_Receitas(BigDecimal total_Receitas) {
		this.total_Receitas = total_Receitas;
	}

}