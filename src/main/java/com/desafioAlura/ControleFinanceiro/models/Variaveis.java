package com.desafioAlura.ControleFinanceiro.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;

import com.desafioAlura.ControleFinanceiro.models.enums.Categoria;

@Entity
public class Variaveis extends Despesas{

	public Variaveis() {
		super();
	
	}

	public Variaveis(Long id, String descricao, BigDecimal valor, Categoria categoria, LocalDate dataPagamento) {
		super(id, descricao, valor, categoria, dataPagamento);
		
	}

	
	
	
	

}
