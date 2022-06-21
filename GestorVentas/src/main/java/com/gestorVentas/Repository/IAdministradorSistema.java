package com.gestorVentas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gestorVentas.Model.*;

@Repository
public interface IAdministradorSistema extends JpaRepository <AdministradorSistema, Integer> {

	public AdministradorSistema findByUsuario(String nombreUsuario);
	
}
