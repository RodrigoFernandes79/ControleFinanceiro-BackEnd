package com.desafioAlura.ControleFinanceiro.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.desafioAlura.ControleFinanceiro.models.Fixas;



@Repository
public interface FixasRepository extends JpaRepository<Fixas, Long>{
	@Query(value="SELECT * FROM DESPESAS WHERE DESCRICAO= :descricao", nativeQuery=true)
	Optional<Fixas> findDespesasFixasBydescricao(@Param(value="descricao")String descricao);
	
	@Query(value="SELECT * FROM DESPESAS WHERE DTYPE= :fixas",nativeQuery=true)
	Optional<Fixas> findDespesasFixasByFixas(@Param(value="fixas")String fixas);
	
}
