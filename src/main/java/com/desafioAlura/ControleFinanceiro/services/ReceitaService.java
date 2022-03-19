package com.desafioAlura.ControleFinanceiro.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioAlura.ControleFinanceiro.models.Receitas;
import com.desafioAlura.ControleFinanceiro.repositories.ReceitasRepository;

@Service
public class ReceitaService {
	
	@Autowired
	private ReceitasRepository repository;

	public Receitas adicionarReceita( Receitas receita) {
		Receitas obj = repository.save(receita);
		return obj;
	}

}
