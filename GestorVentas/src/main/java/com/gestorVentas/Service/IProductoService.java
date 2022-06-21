package com.gestorVentas.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gestorVentas.Model.Producto;

public interface IProductoService {

	
	public Page<Producto> findAll(Pageable pageable);
	public List<Producto> findAll();
	
	public Producto insertarProducto(Producto productoEnt);
	
	public void borrarProducto(Producto productoEnt);
	
	public Optional<Producto> findById(int idProducto);
	
	public Producto actualizarProducto(Producto productoEnt);
	
	public Producto findByName(String nombre);
	
	List<Producto> findListByName(String nombre);
	
	
	
	
	
	
	
	
	
}
