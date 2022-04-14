package com.desafioAlura.ControleFinanceiro.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.NonUniqueResultException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioAlura.ControleFinanceiro.models.Despesas;
import com.desafioAlura.ControleFinanceiro.repositories.DespesasRepository;

@Service
public class DespesaService {

	@Autowired
	private DespesasRepository repository;

	public Despesas adicionarDespesa(Despesas despesas) {
		Optional<Despesas> obj1 = repository.findDespesasBydescricao(despesas.getDescricao());
		if (obj1.isPresent()) {
			throw new NonUniqueResultException("Despesa já existe no Banco de Dados!");
		} else {
			Despesas obj = repository.save(despesas);
			return obj;
		}
	}

	public List<Despesas> listarDespesas() {
		List<Despesas> obj = repository.findAll();

		return obj;
	}

	public Despesas listarDespesasPorId(Long id) {
		Optional<Despesas> obj = repository.findById(id);
		obj.orElseThrow(() -> new NoSuchElementException("Id " + id + " não pode ser encontrado!"));

		return obj.get();
	}

	public Despesas atualizacaoDespesasPorId(@Valid Despesas despesas, Long id) {
		Optional<Despesas> obj1 = repository.findDespesasBydescricao(despesas.getDescricao());
		if (obj1.isPresent() && obj1.get().getId() != id) {
			throw new NonUniqueResultException("Despesa já existe no Banco de Dados!");
		} else {

			return repository.findById(id).map(obj -> {
				obj.getId();
				obj.setDescricao(despesas.getDescricao());
				obj.setValor(despesas.getValor());
				obj.setDataPagamento(despesas.getDataPagamento());
				obj.setCategoria(despesas.getCategoria());
				obj.setTipo(despesas.getTipo());
				Despesas rec = repository.save(obj);

				return rec;
			}).orElseThrow(() -> new NoSuchElementException("Id " + id + " não pode ser encontrado!"));
		}
	}

	public void deletarDespesasPorId(Long id) {
		repository.findById(id).orElseThrow(() -> new NoSuchElementException("Id " + id + " não pode ser encontrado!"));
		repository.deleteById(id);
	}

	public List<Despesas> listarDespesasPorDescricao(String descricao) {
		return repository.ListarDespesasByDescricao(descricao);

	}

	public List<Despesas> listarDespesasPorMesEAno(Integer mes, Integer ano) {

		return repository.listarDespesasByMonthAndYear(mes, ano);
	}

}
