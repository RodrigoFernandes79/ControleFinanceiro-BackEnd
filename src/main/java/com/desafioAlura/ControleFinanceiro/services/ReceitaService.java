package com.desafioAlura.ControleFinanceiro.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.NonUniqueResultException;
import javax.validation.Valid;

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

	public Receitas atualizacaoReceitas(@Valid Receitas receitas, Long id) {
		Optional<Receitas> obj1 = repository.findReceitasBydescricao(receitas.getDescricao());
		if(obj1.isPresent() && obj1.get().getId()!=id) {
			throw new NonUniqueResultException("Receita já existe no Banco de Dados!");
			}else {
				
		return repository.findById(id)
				.map(obj->{
					obj.getId();
					obj.setDescricao(receitas.getDescricao());
					obj.setValor(receitas.getValor());
					obj.setDataRecebimento(receitas.getDataRecebimento());
					Receitas rec = repository.save(obj);
					
					return rec;
			}).orElseThrow(()-> new NoSuchElementException("Id "+ id+ " não pode ser encontrado!"));
			}
	}

	public void deletarReceitasPorId(Long id) {
		repository.findById(id)
		.orElseThrow(()-> new NoSuchElementException("Id "+ id+ " não pode ser encontrado!"));
		repository.deleteById(id);
	}

	public List<Receitas> listarReceitasPorDescricao(String descricao) {
		return repository.ListarReceitasByDescricao(descricao);
		
		
	}

}
