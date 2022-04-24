package com.desafioAlura.ControleFinanceiro.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.desafioAlura.ControleFinanceiro.models.Despesas;
import com.desafioAlura.ControleFinanceiro.models.enums.Categoria;
import com.desafioAlura.ControleFinanceiro.models.enums.Tipo;
import com.fasterxml.jackson.annotation.JsonFormat;

@Repository
public interface DespesasRepository extends JpaRepository<Despesas, Long> {
	@Query(value = "SELECT * FROM DESPESAS WHERE DESCRICAO= :descricao", nativeQuery = true)
	Optional<Despesas> findDespesasBydescricao(@Param(value = "descricao") String descricao);

	@Query(value = "SELECT * FROM DESPESAS WHERE DESCRICAO like %:descricao%", nativeQuery = true)
	List<Despesas> ListarDespesasByDescricao(@Param(value = "descricao") String descricao);

	@Query(value = "SELECT * FROM DESPESAS WHERE extract(MONTH From data_pagamento)= :mes AND extract(year from data_pagamento)= :ano", nativeQuery = true)
	List<Despesas> listarDespesasByMonthAndYear(@Param(value = "mes") Integer mes, @Param(value = "ano") Integer ano);

	@Query(value = "SELECT SUM(valor) AS Total_Despesas FROM DESPESAS WHERE MONTH(data_pagamento) = :mes AND year(data_pagamento) = :ano ;", nativeQuery = true)
	BigDecimal somaTotalDespesas(@Param(value = "mes") Integer mes, @Param(value = "ano") Integer ano);

	@Query(value = "SELECT categoria, SUM(valor) AS valor_total FROM Despesas  WHERE MONTH(data_pagamento) = :mes AND year(data_pagamento) = :ano GROUP BY categoria", nativeQuery = true)
	List<GastoCategoria> listarDespesasPorCategoria(@Param(value = "mes") Integer mes,
			@Param(value = "ano") Integer ano);

	@Query(value = "SELECT categoria, SUM(valor) AS valor_total FROM Despesas GROUP BY CATEGORIA", nativeQuery = true)
	List<GastoCategoria> gastoPorCategoria();

	public static interface GastoCategoria {
		Categoria getCategoria();

		BigDecimal getValor_total();

	}

	@Query(value = "SELECT MONTH(data_pagamento) as dataPagamento, SUM(valor) AS Total_Despesas FROM DESPESAS GROUP BY MONTH(data_pagamento) ORDER BY MONTH(data_pagamento)", nativeQuery = true)
	List<DespesasDTO> totalDespesasPorMes();

	public static interface DespesasDTO {
		@JsonFormat(pattern = "MM")
		int getDataPagamento();

		BigDecimal getTotal_Despesas();
	}

	@Query(value = "SELECT Tipo, Sum(valor) as valor_total from despesas group by tipo;", nativeQuery = true)
	List<GastoTipoDTO> gastoPorTipoDespesas();

	public static interface GastoTipoDTO {
		 Tipo getTipo();

		BigDecimal getValor_total();
	}
	
	@Query(value = "SELECT SUM(valor) AS despesasTotal FROM DESPESAS;", nativeQuery=true)
	BigDecimal totalDespesas();
}