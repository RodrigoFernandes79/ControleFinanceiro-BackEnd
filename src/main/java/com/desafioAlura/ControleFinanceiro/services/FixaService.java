package com.desafioAlura.ControleFinanceiro.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.NonUniqueResultException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioAlura.ControleFinanceiro.models.Fixas;
import com.desafioAlura.ControleFinanceiro.repositories.FixasRepository;

@Service
public class FixaService {

	@Autowired
	private FixasRepository repository;

	public Fixas adicionarDespesaFixa(Fixas fixas) {
		Optional<Fixas> obj1 = repository.findDespesasFixasBydescricao(fixas.getDescricao());
		if (obj1.isPresent()) {
			throw new NonUniqueResultException("Despesa já existe no Banco de Dados!");
		} else {
			Fixas obj = repository.save(fixas);
			return obj;
		}
	}

	public List<Fixas> listarDespesasFixas() {
		List<Fixas> obj = repository.findAll();

		return obj;
	}

	public Fixas listarDespesasFixasPorId(Long id) {
		Optional<Fixas> obj = repository.findById(id);
		obj.orElseThrow(() -> new NoSuchElementException("Id " + id + " não pode ser encontrado!"));

		return obj.get();
	}

	public Fixas atualizacaoDespesasFixasPorId(@Valid Fixas fixas, Long id) {
		Optional<Fixas> obj1 = repository.findDespesasFixasBydescricao(fixas.getDescricao());
		if (obj1.isPresent() && obj1.get().getId() != id) {
			throw new NonUniqueResultException("Despesa já existe no Banco de Dados!");
		} else {

			return repository.findById(id).map(obj -> {
				obj.getId();
				obj.setDescricao(fixas.getDescricao());
				obj.setValor(fixas.getValor());
				obj.setDataPagamento(fixas.getDataPagamento());
				Fixas rec = repository.save(obj);

				return rec;
			}).orElseThrow(() -> new NoSuchElementException("Id " + id + " não pode ser encontrado!"));
		}
	}

	public void deletarDespesasFixasPorId(Long id) {
		repository.findById(id).orElseThrow(() -> new NoSuchElementException("Id " + id + " não pode ser encontrado!"));
		repository.deleteById(id);
	}

}
