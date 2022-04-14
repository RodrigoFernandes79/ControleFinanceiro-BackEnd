package com.desafioAlura.ControleFinanceiro.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Receitas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@NotBlank(message="Campo Obrigatório!")
	@Column(unique = true, nullable = false)
	private String descricao;
	
	@NotNull(message="Campo Obrigatório!")
	@Column(nullable=false)
	private BigDecimal valor;
	
	@NotNull(message="Campo Obrigatório!")
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate dataRecebimento;

	public Receitas() {
		super();
		
	}

	public Receitas(Long id, String descricao, BigDecimal valor, LocalDate dataRecebimento) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.dataRecebimento = dataRecebimento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(LocalDate dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Receitas other = (Receitas) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	

}
