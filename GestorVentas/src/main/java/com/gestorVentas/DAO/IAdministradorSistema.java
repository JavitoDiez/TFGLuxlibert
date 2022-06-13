package com.gestorVentas.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gestorVentas.Entidades.*;

@Repository
public interface IAdministradorSistema extends JpaRepository <AdministradorSistema, Integer> {

	public AdministradorSistema findByUsuario(String nombreUsuario);
	
}
