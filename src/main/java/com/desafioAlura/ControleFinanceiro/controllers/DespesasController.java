package com.desafioAlura.ControleFinanceiro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desafioAlura.ControleFinanceiro.models.Despesas;
import com.desafioAlura.ControleFinanceiro.services.DespesaService;

@RestController
@RequestMapping("/despesas")
public class DespesasController {

	@Autowired
	private DespesaService service;

	@GetMapping("/getall")
	public ResponseEntity<List<Despesas>> listarDespesas() {
		List<Despesas> obj = service.listarDespesas();
		return ResponseEntity.ok().body(obj);
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
