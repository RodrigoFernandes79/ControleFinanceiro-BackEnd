package com.desafioAlura.ControleFinanceiro.DTOs;

import java.math.BigDecimal;
import java.util.List;

import com.desafioAlura.ControleFinanceiro.repositories.DespesasRepository.GastoCategoria;

public class ResumoMesDTO {

	private BigDecimal valorTotalReceitas;

	private BigDecimal valorTotalDespesas;

	private BigDecimal saldoFinalMes;

	private List<GastoCategoria> gastoCategoria;

	public ResumoMesDTO() {
		super();

	}

	public ResumoMesDTO(BigDecimal valorTotalReceitas, BigDecimal valorTotalDespesas, BigDecimal saldoFinalMes,
			List<GastoCategoria> gastoCategoria) {
		super();
		this.valorTotalReceitas = valorTotalReceitas;
		this.valorTotalDespesas = valorTotalDespesas;
		this.saldoFinalMes = saldoFinalMes;
		this.gastoCategoria = gastoCategoria;
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

	public List<GastoCategoria> getGastoCategoria() {
		return gastoCategoria;
	}

	public void setGastoCategoria(List<GastoCategoria> gastoCategoria) {
		this.gastoCategoria = gastoCategoria;
	}

}