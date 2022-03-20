package com.desafioAlura.ControleFinanceiro.exceptions;

public class ApiException {
	
	public String campo;
	public String mensagem;
	
	
	public ApiException(String mensagem) {
		super();
		this.mensagem = mensagem;
	}


	public ApiException(String campo, String mensagem) {
		super();
		this.campo = campo;
		this.mensagem = mensagem;
	}
	
	

}
