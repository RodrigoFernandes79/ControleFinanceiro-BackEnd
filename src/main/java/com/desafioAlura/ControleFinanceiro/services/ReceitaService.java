package com.desafioAlura.ControleFinanceiro.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.NonUniqueResultException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.desafioAlura.ControleFinanceiro.models.Receitas;
import com.desafioAlura.ControleFinanceiro.repositories.ReceitasRepository;

@Service
public class ReceitaService {

	@Autowired
	private ReceitasRepository repository;

	public Receitas adicionarReceita(Receitas receita) {
		Optional<Receitas> obj1 = repository.findReceitasBydescricao(receita.getDescricao());
		if(obj1.isPresent()) {
			throw new NonUniqueResultException("Receita já existe no Banco de Dados!");
			}else {
				Receitas obj = repository.save(receita);
		return obj;
		}
	}

	public List<Receitas> listarReceitas() {
		List<Receitas> obj = repository.findAll();

		return obj;
	}

	public Receitas listarReceitasPorId(Long id) {
		Optional<Receitas> obj = repository.findById(id);
		obj.orElseThrow(()-> new NoSuchElementException("Id "+ id+ " não pode ser encontrado!"));
				
		return obj.get();
	}

}
