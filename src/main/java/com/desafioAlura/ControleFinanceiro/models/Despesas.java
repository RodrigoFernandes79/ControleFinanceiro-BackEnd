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

import com.desafioAlura.ControleFinanceiro.models.enums.Categoria;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public abstract class Despesas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@NotBlank(message = "Campo Obrigatório!")
	@Column(unique = true, nullable = false)
	protected String descricao;

	@NotNull(message = "Campo Obrigatório!")
	@Column(nullable = false)
	protected BigDecimal valor;

	protected Integer categoria;

	@NotNull(message = "Campo Obrigatório!")
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataPagamento;

	public Despesas() {
		super();
		this.setCategoria(Categoria.OUTRAS);

	}

	public Despesas(Long id, String descricao, BigDecimal valor, Categoria categoria, LocalDate dataPagamento) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.categoria = (categoria == null) ? 7 : categoria.getCod();
		this.dataPagamento = dataPagamento;
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

	public Categoria getCategoria() {
		return Categoria.toEnum(categoria);
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria.getCod();
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
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
		Despesas other = (Despesas) obj;
		return Objects.equals(id, other.id);
	}

}
