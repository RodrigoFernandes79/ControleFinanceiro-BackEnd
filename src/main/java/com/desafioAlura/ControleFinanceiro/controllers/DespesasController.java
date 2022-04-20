package com.desafioAlura.ControleFinanceiro.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.desafioAlura.ControleFinanceiro.models.Despesas;

import com.desafioAlura.ControleFinanceiro.services.DespesaService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/despesas")
public class DespesasController {

	@Autowired
	private DespesaService service;
	
	@PostMapping
	public ResponseEntity<Despesas> adicionarDespesa(@Valid @RequestBody Despesas despesas){
		
		Despesas obj = service.adicionarDespesa(despesas);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(obj);
		
	}

	@GetMapping("/getall")
	public ResponseEntity<List<Despesas>> listarDespesas() {
		List<Despesas> obj = service.listarDespesas();
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Despesas> listarDespesasPorId(@PathVariable Long id){
		
		Despesas obj = service.listarDespesasPorId(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Despesas> atualizacaoDespesasFixasPorId(@Valid @RequestBody Despesas despesas , @PathVariable Long id ){
		Despesas obj = service.atualizacaoDespesasPorId(despesas,id);
		
		return ResponseEntity.ok().body(obj);
		
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void deletarDespesasPorId( @PathVariable Long id) {
		service.deletarDespesasPorId(id);
	}


	// buscar por Despesas fixas pela descrição:

	@GetMapping // localhost//8080/despesas?descricao=descricao
	public ResponseEntity<List<Despesas>> listarDespesasPorDescricao(
			@RequestParam(value = "descricao", required = false) String descricao) {
		List<Despesas> obj = service.listarDespesasPorDescricao(descricao);
		return ResponseEntity.ok().body(obj);
	}

	// buscar Despesas por mes e ano:

	@GetMapping(value = "/{ano}/{mes}")
	public ResponseEntity<List<Despesas>> listarDespesasPorMesEAno(@PathVariable("mes") Integer mes,
			@PathVariable("ano") Integer ano) {
		List<Despesas> obj = service.listarDespesasPorMesEAno(mes, ano);
		return ResponseEntity.ok().body(obj);
	}
}
