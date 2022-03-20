package com.desafioAlura.ControleFinanceiro.repositories;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.desafioAlura.ControleFinanceiro.models.Receitas;

@Repository
public interface ReceitasRepository extends JpaRepository<Receitas, Long>{
	@Query(value="SELECT * FROM RECEITAS WHERE DESCRICAO= :descricao", nativeQuery=true)
	Optional<Receitas> findReceitasBydescricao(@Param(value="descricao")String descricao);
	

}
