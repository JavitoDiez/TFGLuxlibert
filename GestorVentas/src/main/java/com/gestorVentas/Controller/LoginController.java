package com.gestorVentas.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.gestorVentas.Entidades.AdministradorSistema;
import com.gestorVentas.Servicio.AdministradorService;
import com.gestorVentas.Servicio.IAdministrador;

@Controller
public class LoginController {

	@Autowired
	AdministradorService adminService;
	
	
	@GetMapping("/login")
	public String login() {
		
		 
		return "login";
	}
	
	
	@PostMapping("/iniciarSesion")
	public String registro(@RequestParam("usuario") String username, @RequestParam("clave") String password) {
		
		AdministradorSistema usuario = adminService.findByUser(username);
		System.out.println("USUARIO ENCONTRADO" + usuario);
		if(usuario.getClaveAdministrador() != password) {
			
			return "login";
		}else if(usuario.getClaveAdministrador() == password) {
			
			
			return "index";
		}
		
		return null;

	}
	
	
}
