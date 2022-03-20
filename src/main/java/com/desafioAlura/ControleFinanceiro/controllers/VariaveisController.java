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

import com.desafioAlura.ControleFinanceiro.models.Variaveis;
import com.desafioAlura.ControleFinanceiro.services.VariavelService;

@RestController
@RequestMapping("/despesas_variaveis")
public class VariaveisController {

	@Autowired
	private VariavelService variavelService;

	@PostMapping
	public ResponseEntity<Variaveis> adicionarDespesaVariavel(@Valid @RequestBody Variaveis variaveis) {

		Variaveis obj = variavelService.adicionarDespesaVariavel(variaveis);

		return ResponseEntity.status(HttpStatus.CREATED).body(obj);

	}

	@GetMapping
	public ResponseEntity<List<Variaveis>> listarDespesasVariaveis() {
		List<Variaveis> obj = variavelService.listarDespesasVariaveis();
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Variaveis> listarDespesasVariaveisPorId(@PathVariable Long id) {

		Variaveis obj = variavelService.listarDespesasVariaveisPorId(id);
		return ResponseEntity.ok().body(obj);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Variaveis> atualizacaoDespesasVariaveisPorId(@Valid @RequestBody Variaveis variaveis,
			@PathVariable Long id) {
		Variaveis obj = variavelService.atualizacaoDespesasVariaveisPorId(variaveis, id);

		return ResponseEntity.ok().body(obj);

	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void deletarDespesasVariaveisPorId(@PathVariable Long id) {
		variavelService.deletarDespesasVariaveisPorId(id);
	}

}
