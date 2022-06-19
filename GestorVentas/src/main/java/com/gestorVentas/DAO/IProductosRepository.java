package com.gestorVentas.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gestorVentas.Entidades.CategoriaProducto;
import com.gestorVentas.Entidades.Producto;

@Repository
public interface IProductosRepository extends JpaRepository<Producto, Integer>{

	@Query(value="SELECT * FROM productos_acabados  where nombre_producto = :nombre ",nativeQuery = true)
	public Producto findByName(@Param("nombre") String nombre);
	
	@Query(value="SELECT * FROM productos_acabados  where nombre_producto = :nombre ",nativeQuery = true)
	public List<Producto> findListByName(@Param("nombre") String nombre);
}
