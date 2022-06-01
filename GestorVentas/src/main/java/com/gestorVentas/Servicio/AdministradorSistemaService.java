package com.gestorVentas.Servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestorVentas.DAO.IAdministradorSistema;

@Service
public class AdministradorSistemaService implements IAdministradorSistemaService{

	@Autowired
	private IAdministradorSistema administradorSistema;
	
	@Override
	public void findByUserAndPass(String usuario, String clave) {
		
		if(usuario != null || clave != null) {
			administradorSistema.findByNameAndPassword(usuario, clave);
		}
		
		
	}

}
