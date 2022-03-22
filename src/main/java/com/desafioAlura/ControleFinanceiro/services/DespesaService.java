package com.desafioAlura.ControleFinanceiro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioAlura.ControleFinanceiro.models.Despesas;
import com.desafioAlura.ControleFinanceiro.repositories.DespesasRepository;

@Service
public class DespesaService {

	@Autowired
	private DespesasRepository repository;

	public List<Despesas> listarDespesas() {
		List<Despesas> obj = repository.findAll();

		return obj;
	}

	public List<Despesas> listarDespesasPorDescricao(String descricao) {
		return repository.ListarDespesasByDescricao(descricao);

	}

	public List<Despesas> listarDespesasPorMesEAno(Integer mes, Integer ano) {

		return repository.listarDespesasByMonthAndYear(mes, ano);
	}

}
