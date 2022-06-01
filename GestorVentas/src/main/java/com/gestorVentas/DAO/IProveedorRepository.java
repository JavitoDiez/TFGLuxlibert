package com.gestorVentas.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gestorVentas.Entidades.ProductoEnt;
import com.gestorVentas.Entidades.Proveedor;

@Repository
public interface IProveedorRepository extends JpaRepository <Proveedor,Integer>{
	
	
	@Query(value="SELECT * FROM proveedores  where nombre_proveedor = :nombre ",nativeQuery = true)
	public Proveedor findByName(@Param("nombre") String nombre);
	
	
}
