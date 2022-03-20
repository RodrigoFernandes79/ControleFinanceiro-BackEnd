package com.desafioAlura.ControleFinanceiro.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.desafioAlura.ControleFinanceiro.models.Variaveis;



@Repository
public interface VariaveisRepository extends JpaRepository<Variaveis, Long>{
	@Query(value="SELECT * FROM DESPESAS WHERE DESCRICAO= :descricao", nativeQuery=true)
	Optional<Variaveis> findDespesasVariaveisBydescricao(@Param(value="descricao")String descricao);
	
	@Query(value="SELECT * FROM DESPESAS WHERE DTYPE= :variaveis",nativeQuery=true)
	Optional<Variaveis> findDespesasVariaveisByvariaveis(@Param(value="variaveis")String variaveis);
	
}
