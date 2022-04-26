package com.desafioAlura.ControleFinanceiro.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.desafioAlura.ControleFinanceiro.models.Receitas;
import com.fasterxml.jackson.annotation.JsonFormat;

@Repository
@Transactional
public interface ReceitasRepository extends JpaRepository<Receitas, Long> {
	@Query(value = "SELECT * FROM RECEITAS WHERE DESCRICAO= :descricao", nativeQuery = true)
	Optional<Receitas> findReceitasBydescricao(@Param(value = "descricao") String descricao);

	@Query(value = "SELECT * FROM RECEITAS WHERE DESCRICAO like %:descricao%", nativeQuery = true)
	List<Receitas> ListarReceitasByDescricao(@Param(value = "descricao") String descricao);

	@Query(value = "SELECT * FROM RECEITAS WHERE extract(MONTH From data_recebimento)= :mes AND extract(year from data_recebimento)= :ano", nativeQuery = true)
	List<Receitas> listarReceitasByMonthAndYear(@Param(value = "mes") Integer mes, @Param(value = "ano") Integer ano);

	@Query(value = "SELECT SUM(valor) AS Total_Receita FROM RECEITAS WHERE extract(MONTH From data_recebimento)= :mes AND extract(year from data_recebimento)= :ano", nativeQuery = true)
	BigDecimal somaTotalReceitas(@Param(value = "mes") Integer mes, @Param(value = "ano") Integer ano);

	@Query(value = "SELECT EXTRACT(MONTH FROM data_recebimento) as dataRecebimento, SUM(valor) AS Total_Receitas FROM RECEITAS GROUP BY EXTRACT(MONTH FROM data_recebimento) ORDER BY EXTRACT(MONTH FROM data_recebimento)", nativeQuery = true)
	List<ReceitasDTO> totalReceitasPorMes();

	public static interface ReceitasDTO {
		@JsonFormat(pattern = "MM")
		int getDataRecebimento();

		BigDecimal getTotal_Receitas();
	}
	@Query(value = "SELECT SUM(valor) AS receitasTotal FROM RECEITAS;", nativeQuery=true)
	BigDecimal totalReceitas();
}
