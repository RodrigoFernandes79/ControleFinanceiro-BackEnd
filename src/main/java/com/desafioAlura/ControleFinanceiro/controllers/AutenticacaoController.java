package com.desafioAlura.ControleFinanceiro.controllers;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafioAlura.ControleFinanceiro.config.TokenDto;
import com.desafioAlura.ControleFinanceiro.config.TokenService;
import com.desafioAlura.ControleFinanceiro.controllers.form.LoginForm;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;

	@PostMapping
	ResponseEntity<TokenDto> autenticar(@RequestBody LoginForm form){
		
		UsernamePasswordAuthenticationToken dadosLogin = form.converter();
		try {
		Authentication authentication =  authManager.authenticate(dadosLogin);
		//Método para gerar o Token:
		String token = tokenService.gerarToken(authentication);
		
		
		return ResponseEntity.ok(new TokenDto(token, "Bearer"));
		
		}catch(org.springframework.security.core.AuthenticationException e){
			return ResponseEntity.badRequest().build();		
			}
	}
}
