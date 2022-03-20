package com.desafioAlura.ControleFinanceiro.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.desafioAlura.ControleFinanceiro.models.Fixas;
import com.desafioAlura.ControleFinanceiro.services.FixaService;

@RestController
@RequestMapping("/despesas_fixas")
public class FixasController {
	
	@Autowired
	private FixaService fixaService;
	
	@PostMapping
	public ResponseEntity<Fixas> adicionarDespesaFixa(@Valid @RequestBody Fixas fixas){
		
		Fixas obj = fixaService.adicionarDespesaFixa(fixas);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(obj);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Fixas>> listarDespesasFixas(){
		List<Fixas> obj = fixaService.listarDespesasFixas();
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Fixas> listarDespesasFixasPorId(@PathVariable Long id){
		
		Fixas obj = fixaService.listarDespesasFixasPorId(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Fixas> atualizacaoDespesasFixasPorId(@Valid @RequestBody Fixas fixas , @PathVariable Long id ){
		Fixas obj = fixaService.atualizacaoDespesasFixasPorId(fixas,id);
		
		return ResponseEntity.ok().body(obj);
		
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void deletarDespesasFixasPorId( @PathVariable Long id) {
		fixaService.deletarDespesasFixasPorId(id);
	}

	
	

}
