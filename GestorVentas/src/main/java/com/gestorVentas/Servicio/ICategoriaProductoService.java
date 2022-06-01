package com.gestorVentas.Servicio;

import java.util.List;

import com.gestorVentas.Entidades.CategoriaProducto;

public interface ICategoriaProductoService {
	
	public CategoriaProducto insertarCategoria(CategoriaProducto categoriaProducto);
	
	public CategoriaProducto findByName(String nombreCategoria);

	public List<CategoriaProducto> findAll();
}
