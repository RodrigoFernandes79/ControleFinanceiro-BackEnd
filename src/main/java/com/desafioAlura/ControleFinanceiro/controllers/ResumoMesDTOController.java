package com.desafioAlura.ControleFinanceiro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafioAlura.ControleFinanceiro.DTOs.ResumoMesDTO;
import com.desafioAlura.ControleFinanceiro.services.ResumoMesDTOService;

@CrossOrigin("*")
@RestController
@RequestMapping("/resumo")
public class ResumoMesDTOController {

	@Autowired
	private ResumoMesDTOService resumoService;

	@GetMapping("/{ano}/{mes}")
	public ResponseEntity<ResumoMesDTO> buscarResumoMensal(@PathVariable("mes") Integer mes,
			@PathVariable("ano") Integer ano) {
		ResumoMesDTO obj = resumoService.buscarResumoMensal(mes, ano);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<ResumoMesDTO> gastoPorCategoria() {
		ResumoMesDTO obj = resumoService.gastoPorCategoria();
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping("/totalReceitas")
	public ResponseEntity<ResumoMesDTO> totalReceitasPorMes() {
		ResumoMesDTO obj = resumoService.totalReceitasPorMes();
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping("/totalDespesas")
	public ResponseEntity<ResumoMesDTO> totalDespesasPorMes() {
		ResumoMesDTO obj = resumoService.totalDespesasPorMes();
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping("/saldoMensal")
	public ResponseEntity<ResumoMesDTO> saldoMensal(){
		ResumoMesDTO obj = resumoService.saldoMensal();
		return ResponseEntity.ok().body(obj);
	}
}
