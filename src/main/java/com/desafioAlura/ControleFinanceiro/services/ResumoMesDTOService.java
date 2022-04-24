package com.desafioAlura.ControleFinanceiro.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioAlura.ControleFinanceiro.DTOs.ResumoMesDTO;
import com.desafioAlura.ControleFinanceiro.repositories.DespesasRepository;
import com.desafioAlura.ControleFinanceiro.repositories.DespesasRepository.DespesasDTO;
import com.desafioAlura.ControleFinanceiro.repositories.DespesasRepository.GastoCategoria;
import com.desafioAlura.ControleFinanceiro.repositories.ReceitasRepository;
import com.desafioAlura.ControleFinanceiro.repositories.ReceitasRepository.ReceitasDTO;

@Service
public class ResumoMesDTOService {

	@Autowired
	private ReceitasRepository receitaRepository;

	@Autowired
	private DespesasRepository despesaRepository;

	public ResumoMesDTO buscarResumoMensal(Integer mes, Integer ano) {
		ResumoMesDTO resumoMes = new ResumoMesDTO();

		BigDecimal totalReceita = receitaRepository.somaTotalReceitas(mes, ano);
		if (totalReceita != null) {
			resumoMes.setValorTotalReceitas(totalReceita);

		} else {
			resumoMes.setValorTotalReceitas(BigDecimal.valueOf(0));
			totalReceita = BigDecimal.valueOf(0);
		}
		BigDecimal totalDespesa = despesaRepository.somaTotalDespesas(mes, ano);
		if (totalDespesa != null) {
			resumoMes.setValorTotalDespesas(totalDespesa);
		} else {
			resumoMes.setValorTotalDespesas(BigDecimal.valueOf(0));
			totalDespesa = BigDecimal.valueOf(0);
		}

		BigDecimal saldoFinalMes = totalReceita.subtract(totalDespesa);

		resumoMes.setSaldoFinalMes(saldoFinalMes);

		List<GastoCategoria> listarCategoriaMes = despesaRepository.listarDespesasPorCategoria(mes, ano);

		resumoMes.setGastoCategoria(listarCategoriaMes);

		return resumoMes;
	}

	public ResumoMesDTO gastoPorCategoria() {
		ResumoMesDTO resumoMesDTO = new ResumoMesDTO();
		List<GastoCategoria> gastoCategoria = despesaRepository.gastoPorCategoria();
		resumoMesDTO.setGastoCategoria(gastoCategoria);
		return resumoMesDTO;
	}

	public ResumoMesDTO totalReceitasPorMes() {
		ResumoMesDTO resumoMes = new ResumoMesDTO();
		List<ReceitasDTO> receitasDTO = receitaRepository.totalReceitasPorMes();
		resumoMes.setReceitasDTO(receitasDTO);
		return resumoMes;
	}

	public ResumoMesDTO totalDespesasPorMes() {
		ResumoMesDTO resumoMesDTO = new ResumoMesDTO();
		List<DespesasDTO> despesasDTO = despesaRepository.totalDespesasPorMes();
		resumoMesDTO.setDespesasDTO(despesasDTO);
		return resumoMesDTO;
	}

	public ResumoMesDTO saldoMensal() {
		ResumoMesDTO resumoMes = new ResumoMesDTO();
		BigDecimal receitaTotal = receitaRepository.totalReceitas();
		if (receitaTotal != null) {
			resumoMes.setReceitasTotal(receitaTotal);

		} else {
			resumoMes.setReceitasTotal(BigDecimal.valueOf(0));
			receitaTotal = BigDecimal.valueOf(0);
		}

		BigDecimal despesaTotal = despesaRepository.totalDespesas();
		if (despesaTotal != null) {
			resumoMes.setDespesasTotal(despesaTotal);

		} else {
			resumoMes.setDespesasTotal(BigDecimal.valueOf(0));
			despesaTotal = BigDecimal.valueOf(0);
		}

		BigDecimal saldo = receitaTotal.subtract(despesaTotal);
		resumoMes.setTotalSaldo(saldo);

		return resumoMes;
	}

}
