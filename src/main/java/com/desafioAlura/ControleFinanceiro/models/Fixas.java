package com.desafioAlura.ControleFinanceiro.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Fixas extends Despesas{

	public Fixas() {
		super();
	
	}

	public Fixas(Long id, String descricao, BigDecimal valor, LocalDate dataPagamento) {
		super(id, descricao, valor, dataPagamento);
		
	}
	
	

}
