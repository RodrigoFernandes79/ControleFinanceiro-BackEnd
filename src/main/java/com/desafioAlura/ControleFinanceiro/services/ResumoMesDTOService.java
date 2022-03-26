package com.desafioAlura.ControleFinanceiro.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioAlura.ControleFinanceiro.DTOs.ResumoMesDTO;
import com.desafioAlura.ControleFinanceiro.repositories.DespesasRepository;
import com.desafioAlura.ControleFinanceiro.repositories.DespesasRepository.GastoCategoria;
import com.desafioAlura.ControleFinanceiro.repositories.ReceitasRepository;

@Service
public class ResumoMesDTOService {

	@Autowired
	private ReceitasRepository receitaRepository;

	@Autowired
	private DespesasRepository despesaRepository;

	public ResumoMesDTO buscarResumoMensal(Integer mes, Integer ano) {
		ResumoMesDTO resumoMes = new ResumoMesDTO();

		BigDecimal totalReceita = receitaRepository.somaTotalReceitas(mes, ano);
		if (totalReceita != BigDecimal.ZERO) {
			resumoMes.setValorTotalReceitas(totalReceita);
		} else {
			resumoMes.setValorTotalReceitas(BigDecimal.ZERO);
		}
		BigDecimal totalDespesa = despesaRepository.somaTotalDespesas(mes, ano);
		if (totalDespesa != BigDecimal.ZERO) {
			resumoMes.setValorTotalDespesas(totalDespesa);
		} else {
			resumoMes.setValorTotalDespesas(BigDecimal.ZERO);
		}

		BigDecimal saldoFinalMes = totalReceita.subtract(totalDespesa);
		resumoMes.setSaldoFinalMes(saldoFinalMes);

		List<GastoCategoria> listarCategoriaMes = despesaRepository.listarDespesasPorCategoria(mes, ano);

		resumoMes.setGastoCategoria(listarCategoriaMes);

		return resumoMes;
	}

}