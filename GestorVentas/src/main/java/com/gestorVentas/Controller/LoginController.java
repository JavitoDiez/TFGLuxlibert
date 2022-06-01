package com.gestorVentas.Controller;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gestorVentas.Servicio.AdministradorSistemaService;

@Controller
public class LoginController extends HttpServlet {

	@Autowired
	private AdministradorSistemaService administradorSistemaService;
	
	@GetMapping("/login")
	public String loginView() {
		return "login";
	}
	@PostMapping("/login")
	public String login (@Param("usuario") String usuario, @Param("clave") String clave) {
		
		
			administradorSistemaService.findByUserAndPass(usuario, clave);
		
		return "redirect:/productos";
	}
}
