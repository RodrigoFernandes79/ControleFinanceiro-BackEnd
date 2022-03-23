package com.desafioAlura.ControleFinanceiro.repositories;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.desafioAlura.ControleFinanceiro.models.Despesas;

@Repository
public interface DespesasRepository extends JpaRepository<Despesas, Long> {
	@Query(value = "SELECT * FROM DESPESAS WHERE DESCRICAO= :descricao", nativeQuery = true)
	Optional<Despesas> findDespesasBydescricao(@Param(value = "descricao") String descricao);

	@Query(value = "SELECT * FROM DESPESAS WHERE DESCRICAO like :descricao", nativeQuery = true)
	List<Despesas> ListarDespesasByDescricao(@Param(value = "descricao") String descricao);

	@Query(value = "SELECT * FROM DESPESAS WHERE MONTH(data_pagamento)= :mes AND year(data_pagamento)= :ano", nativeQuery = true)
	List<Despesas> listarDespesasByMonthAndYear(@Param(value = "mes") Integer mes, @Param(value = "ano") Integer ano);
	
	@Query(value= "SELECT SUM(valor) AS Total_Despesas FROM DESPESAS WHERE MONTH(data_pagamento) = :mes AND year(data_pagamento) = :ano ;",nativeQuery=true)
	BigDecimal somaTotalDespesas(@Param(value = "mes") Integer mes, @Param(value = "ano") Integer ano);
}


