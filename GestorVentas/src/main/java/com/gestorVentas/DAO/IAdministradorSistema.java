package com.gestorVentas.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gestorVentas.Entidades.*;

public interface IAdministradorSistema extends JpaRepository <AdministradorSistema, Integer> {

	@Query(value="SELECT * FROM administradoressistema  where usuario_administrador = :usuario and clave_administrador = :clave ",nativeQuery = true)
	public void findByNameAndPassword(@Param("usuario") String usuario, @Param("clave") String clave);
	
}
