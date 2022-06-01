package com.gestorVentas.Servicio;

import com.gestorVentas.Entidades.AdministradorSistema;

public interface IAdministradorSistemaService {

	public void findByUserAndPass(String usuario,String clave);
	
}
