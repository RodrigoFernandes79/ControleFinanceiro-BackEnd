package com.desafioAlura.ControleFinanceiro.DTOs;

import java.math.BigDecimal;
import java.util.List;

import com.desafioAlura.ControleFinanceiro.repositories.DespesasRepository.DespesasDTO;
import com.desafioAlura.ControleFinanceiro.repositories.DespesasRepository.GastoCategoria;
import com.desafioAlura.ControleFinanceiro.repositories.ReceitasRepository.ReceitasDTO;

public class ResumoMesDTO {

	private BigDecimal valorTotalReceitas;

	private BigDecimal valorTotalDespesas;

	private BigDecimal saldoFinalMes;

	private List<GastoCategoria> gastoCategoria;

	private List<ReceitasDTO> receitasDTO;

	private List<DespesasDTO> despesasDTO;

	private BigDecimal receitasTotal;

	private BigDecimal despesasTotal;

	private BigDecimal totalSaldo;

	public ResumoMesDTO() {
		super();

	}

	public ResumoMesDTO(BigDecimal valorTotalReceitas, BigDecimal valorTotalDespesas, BigDecimal saldoFinalMes,
			List<GastoCategoria> gastoCategoria, List<ReceitasDTO> receitasDTO, List<DespesasDTO> despesasDTO,
			BigDecimal receitasTotal, BigDecimal despesasTotal, BigDecimal totalSaldo) {
		super();
		this.valorTotalReceitas = valorTotalReceitas;
		this.valorTotalDespesas = valorTotalDespesas;
		this.saldoFinalMes = saldoFinalMes;
		this.gastoCategoria = gastoCategoria;
		this.receitasDTO = receitasDTO;
		this.despesasDTO = despesasDTO;
		this.receitasTotal = receitasTotal;
		this.despesasTotal = despesasTotal;
		this.totalSaldo = totalSaldo;
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

	public List<ReceitasDTO> getReceitasDTO() {
		return receitasDTO;
	}

	public void setReceitasDTO(List<ReceitasDTO> receitasDTO) {
		this.receitasDTO = receitasDTO;
	}

	public List<DespesasDTO> getDespesasDTO() {
		return despesasDTO;
	}

	public void setDespesasDTO(List<DespesasDTO> despesasDTO) {
		this.despesasDTO = despesasDTO;
	}

	public BigDecimal getReceitasTotal() {
		return receitasTotal;
	}

	public void setReceitasTotal(BigDecimal receitasTotal) {
		this.receitasTotal = receitasTotal;
	}

	public BigDecimal getDespesasTotal() {
		return despesasTotal;
	}

	public void setDespesasTotal(BigDecimal despesasTotal) {
		this.despesasTotal = despesasTotal;
	}

	public BigDecimal getTotalSaldo() {
		return totalSaldo;
	}

	public void setTotalSaldo(BigDecimal totalSaldo) {
		this.totalSaldo = totalSaldo;
	}

	
}
