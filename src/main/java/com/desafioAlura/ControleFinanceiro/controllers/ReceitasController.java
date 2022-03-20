package com.desafioAlura.ControleFinanceiro.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.desafioAlura.ControleFinanceiro.models.Receitas;
import com.desafioAlura.ControleFinanceiro.services.ReceitaService;

@RestController
@RequestMapping("/receitas")
public class ReceitasController {
	
	@Autowired
	private ReceitaService receitaService;
	
	@PostMapping
	public ResponseEntity<Receitas> adicionarReceita(@Valid @RequestBody Receitas receita){
		
		Receitas obj = receitaService.adicionarReceita(receita);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(obj);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Receitas>> listarReceitas(){
		List<Receitas> obj = receitaService.listarReceitas();
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Receitas> listarReceitasPorId(@PathVariable Long id){
		
		Receitas obj = receitaService.listarReceitasPorId(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Receitas> atualizacaoReceitas(@Valid @RequestBody Receitas receitas , @PathVariable Long id ){
		Receitas obj = receitaService.atualizacaoReceitas(receitas,id);
		
		return ResponseEntity.ok().body(obj);
		
	}

	
	

}
