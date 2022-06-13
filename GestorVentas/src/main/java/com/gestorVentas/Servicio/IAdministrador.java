package com.gestorVentas.Servicio;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestorVentas.Entidades.AdministradorSistema;

@Repository
public interface IAdministrador  {

	
	public AdministradorSistema findByUser(String usuario);
}
