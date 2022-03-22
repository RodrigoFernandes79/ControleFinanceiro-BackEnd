package com.desafioAlura.ControleFinanceiro.repositories;




import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.desafioAlura.ControleFinanceiro.models.Receitas;

@Repository
@Transactional
public interface ReceitasRepository extends JpaRepository<Receitas, Long>{
	@Query(value="SELECT * FROM RECEITAS WHERE DESCRICAO= :descricao", nativeQuery=true)
	Optional<Receitas> findReceitasBydescricao(@Param(value="descricao")String descricao);
	
	@Query(value="SELECT * FROM RECEITAS WHERE DESCRICAO like :descricao", nativeQuery=true)
	List<Receitas> ListarReceitasByDescricao(@Param(value="descricao") String descricao);
	
	@Query(value="SELECT * FROM RECEITAS WHERE MONTH(data_recebimento)= :mes AND year(data_recebimento)= :ano",nativeQuery=true)
	List<Receitas> listarReceitasByMonthAndYear(@Param(value="mes")Integer mes,@Param(value="ano") Integer ano );
	

}
