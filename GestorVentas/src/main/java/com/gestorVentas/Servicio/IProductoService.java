package com.gestorVentas.Servicio;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gestorVentas.Entidades.ProductoEnt;

public interface IProductoService {

	
	public Page<ProductoEnt> findAll(Pageable pageable);
	public List<ProductoEnt> findAll();
	
	public ProductoEnt insertarProducto(ProductoEnt productoEnt);
	
	public void borrarProducto(ProductoEnt productoEnt);
	
	public Optional<ProductoEnt> findById(int idProducto);
	
	public ProductoEnt actualizarProducto(ProductoEnt productoEnt);
	
	public ProductoEnt findByName(String nombre);
	
	
	
	
	
	
	
	
	
}
