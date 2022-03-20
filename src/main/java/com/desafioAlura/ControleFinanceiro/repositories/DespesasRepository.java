package com.desafioAlura.ControleFinanceiro.repositories;

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

}
