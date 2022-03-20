package com.desafioAlura.ControleFinanceiro.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.NonUniqueResultException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioAlura.ControleFinanceiro.models.Variaveis;
import com.desafioAlura.ControleFinanceiro.repositories.VariaveisRepository;

@Service
public class VariavelService {

	@Autowired
	private VariaveisRepository repository;

	public Variaveis adicionarDespesaVariavel(Variaveis variaveis) {
		Optional<Variaveis> obj1 = repository.findDespesasVariaveisBydescricao(variaveis.getDescricao());
		if (obj1.isPresent()) {
			throw new NonUniqueResultException("Despesa Variável já existe no Banco de Dados!");
		} else {
			Variaveis obj = repository.save(variaveis);
			return obj;
		}
	}

	public List<Variaveis> listarDespesasVariaveis() {
		List<Variaveis> obj = repository.findAll();

		return obj;
	}

	public Variaveis listarDespesasVariaveisPorId(Long id) {
		Optional<Variaveis> obj = repository.findById(id);
		obj.orElseThrow(() -> new NoSuchElementException("Id " + id + " não pode ser encontrado!"));

		return obj.get();
	}

	public Variaveis atualizacaoDespesasVariaveisPorId(@Valid Variaveis variaveis, Long id) {
		Optional<Variaveis> obj1 = repository.findDespesasVariaveisBydescricao(variaveis.getDescricao());
		if (obj1.isPresent() && obj1.get().getId() != id) {
			throw new NonUniqueResultException("Despesa Variável já existe no Banco de Dados!");
		} else {

			return repository.findById(id).map(obj -> {
				obj.getId();
				obj.setDescricao(variaveis.getDescricao());
				obj.setValor(variaveis.getValor());
				obj.setDataPagamento(variaveis.getDataPagamento());
				Variaveis rec = repository.save(obj);

				return rec;
			}).orElseThrow(() -> new NoSuchElementException("Id " + id + " não pode ser encontrado!"));
		}
	}

	public void deletarDespesasVariaveisPorId(Long id) {
		repository.findById(id).orElseThrow(() -> new NoSuchElementException("Id " + id + " não pode ser encontrado!"));
		repository.deleteById(id);
	}

}
