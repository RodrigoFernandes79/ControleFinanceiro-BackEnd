package com.desafioAlura.ControleFinanceiro.config;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.desafioAlura.ControleFinanceiro.repositories.UsuarioRepository;

@EnableWebSecurity
public class SrpingSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AutenticacaoService autenticacaoService;  //injetando a regra de autenticação
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
		@Override
		@Bean
		protected AuthenticationManager authenticationManager() throws Exception {
			// TODO Auto-generated method stub
			return super.authenticationManager();
		}
	
	//Configurações de Autenticação
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	//Configurações de Autorização
      @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests()
    	.antMatchers(HttpMethod.GET, "/receitas/*").permitAll() //permitindo apenas o acesso da requisição "receitas
    	.antMatchers(HttpMethod.POST, "/auth").permitAll() // liberando a autenticaçãoController
    	.anyRequest().authenticated()
    	.and().csrf().disable()
    	.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    	.and().addFilterBefore(new AutenticacaoViaTokenFilter(tokenService,usuarioRepository), UsernamePasswordAuthenticationFilter.class);
    }

     
}