package com.gestorVentas.Service;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestorVentas.Model.AdministradorSistema;

@Repository
public interface IAdministrador  {

	
	public AdministradorSistema findByUser(String usuario);
}
