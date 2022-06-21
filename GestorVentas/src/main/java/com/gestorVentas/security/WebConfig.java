package com.gestorVentas.security;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gestorVentas.Service.AdministradorService;

@Configuration
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter {

	@Bean 
	public PasswordEncoder passwordEncoder() { 
	    return new BCryptPasswordEncoder(); 
	}

	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
	    auth.inMemoryAuthentication()
	        .withUser("fernando").password(passwordEncoder().encode("fernando")).roles("USER")
	        .and()
	        .withUser("AdministradorSistema").password(passwordEncoder().encode("admin")).roles("USER")
	        .and()
	        .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN");
	}



	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.authorizeRequests()
		.antMatchers("/css/**","/img/**","/js/**").permitAll()
		.and().formLogin().loginPage("/login")
		.loginProcessingUrl("/comprobarLogin")
		.usernameParameter("usuario")
		.passwordParameter("clave")
		.defaultSuccessUrl("/productos",true).permitAll()
		.failureUrl("/login?error=true")
		
		.and()
	      .logout()
	      .logoutUrl("/logout")
	      .deleteCookies("JSESSIONID");
		
		
		
		
		super.configure(http);
	}
	
	
	
}
