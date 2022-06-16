package com.gestorVentas.Servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	
	public void sendEmail(Double importeCompra) {
		
		SimpleMailMessage mensaje = new SimpleMailMessage();
		
		String importeStr = String.valueOf(importeCompra); 
		mensaje.setFrom("javidigilarte@gmail.com");
		mensaje.setTo("javitogilarte@gmail.com");
		mensaje.setSubject("Alerta De Compra");
		mensaje.setText("El sistema ha detectado una compra superior al límite establecido por la empresa\n"
				+ "El monto total de la compra realizada es:  "+importeStr );
		
		
		javaMailSender.send(mensaje);
		
	}
	
}
