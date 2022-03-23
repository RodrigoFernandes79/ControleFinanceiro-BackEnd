package com.desafioAlura.ControleFinanceiro.DTOs;

import java.math.BigDecimal;








public class ResumoMesDTO {
	
	
	private BigDecimal valorTotalReceitas;
	
	private BigDecimal valorTotalDespesas;
	
	private BigDecimal saldoFinalMes;

	public ResumoMesDTO() {
		super();
		
	}

	public ResumoMesDTO(BigDecimal valorTotalReceitas, BigDecimal valorTotalDespesas, BigDecimal saldoFinalMes) {
		super();
		this.valorTotalReceitas = valorTotalReceitas;
		this.valorTotalDespesas = valorTotalDespesas;
		this.saldoFinalMes = saldoFinalMes;
	}

	public BigDecimal getValorTotalReceitas() {
		return valorTotalReceitas;
	}

	public void setValorTotalReceitas(BigDecimal valorTotalReceitas) {
		this.valorTotalReceitas = valorTotalReceitas;
	}

	public BigDecimal getValorTotalDespesas() {
		return valorTotalDespesas;
	}

	public void setValorTotalDespesas(BigDecimal valorTotalDespesas) {
		this.valorTotalDespesas = valorTotalDespesas;
	}

	public BigDecimal getSaldoFinalMes() {
		return saldoFinalMes;
	}

	public void setSaldoFinalMes(BigDecimal saldoFinalMes) {
		this.saldoFinalMes = saldoFinalMes;
	}
	
	

}