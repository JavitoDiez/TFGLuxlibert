package com.gestorVentas.Service;

import java.util.List;

import com.gestorVentas.Model.CategoriaProducto;

public interface ICategoriaProductoService {
	
	public CategoriaProducto insertarCategoria(CategoriaProducto categoriaProducto);
	
	public CategoriaProducto findByName(String nombreCategoria);

	public List<CategoriaProducto> findAll();
}
