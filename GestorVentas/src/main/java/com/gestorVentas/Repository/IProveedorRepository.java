package com.gestorVentas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gestorVentas.Model.Producto;
import com.gestorVentas.Model.Proveedor;

@Repository
public interface IProveedorRepository extends JpaRepository <Proveedor,Integer>{
	
	
	@Query(value="SELECT * FROM proveedores  where nombre_proveedor = :nombre ",nativeQuery = true)
	public Proveedor findByName(@Param("nombre") String nombre);
	
	
}
