package com.desafioAlura.ControleFinanceiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafioAlura.ControleFinanceiro.models.Receitas;

@Repository
public interface ReceitasRepository extends JpaRepository<Receitas, Long>{

}
