package com.gestorVentas.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.gestorVentas.Model.AdministradorSistema;
import com.gestorVentas.Service.AdministradorService;
import com.gestorVentas.Service.IAdministrador;

@Controller
public class LoginController {

	@Autowired
	AdministradorService adminService;

	@GetMapping("/login")
	public String login() {

		return "login";
	}

	@GetMapping("/inicio")
	public String inicio() {

		return "index";
	}

	/*@GetMapping("/login?error")
	public String errorLogin(Model model,@RequestParam("error") String param) {

		String error="usuario o contraseña incorrecto";
		
		model.addAttribute("errorLogin",error);
		
		
		return "login";
	}*/
	
	
	@GetMapping("/logout")
	public String logout() {

		return "login";
	}
	

	/*@PostMapping("/comprobarLogin")
	public String registro(@RequestParam("usuario") String username, @RequestParam("clave") String password) {

		AdministradorSistema usuario = adminService.findByUser(username);
		System.out.println("USUARIO ENCONTRADO" + usuario);
		if (usuario.getClaveAdministrador() != password) {

			return "login";
		} else if (usuario.getClaveAdministrador() == password) {

			return "index";
		}

		return null;

	}*/

}
