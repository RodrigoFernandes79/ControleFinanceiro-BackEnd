package com.desafioAlura.ControleFinanceiro.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
//	//Configurações de Autenticação
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ROLE");
//	}
//	
//	//Configurações de Autorização
//      @Override
//    protected void configure(HttpSecurity http) throws Exception {
//    	http.authorizeRequests()
//    	.antMatchers(HttpMethod.GET, "/receitas/*").permitAll() //permitindo apenas o acesso da requisição "receitas
//    	.anyRequest().authenticated()
//    	.and().httpBasic()
//    	.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//    	.and().csrf().disable();
//    }
//}