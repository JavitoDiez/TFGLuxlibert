package com.gestorVentas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gestorVentas.Model.CategoriaProducto;

@Repository
public interface ICategoriaProducto extends JpaRepository<CategoriaProducto, Integer> {
	
	@Query(value="SELECT * FROM categoriaproducto  where categoria = :nombreCategoria ",nativeQuery = true)
	public CategoriaProducto findByNameCategoria(@Param("nombreCategoria") String nombreCategoria);
}
