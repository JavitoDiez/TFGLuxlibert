package com.gestorVentas.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestorVentas.Model.CategoriaProducto;
import com.gestorVentas.Repository.ICategoriaProducto;

@Service
public class CategoriaProductoService implements ICategoriaProductoService {

	@Autowired
	ICategoriaProducto categoriaProductoDao ;
	
	@Override
	public CategoriaProducto insertarCategoria(CategoriaProducto categoriaProducto) {
		
		return categoriaProductoDao.save(categoriaProducto);
	}

	@Override
	public CategoriaProducto findByName(String nombreCategoria) {
		// TODO Auto-generated method stub
		return categoriaProductoDao.findByNameCategoria(nombreCategoria);
	}

	@Override
	public List<CategoriaProducto> findAll() {
		
		return categoriaProductoDao.findAll();
	}

	/*@Override
	public CategoriaProducto findByName(String nombreCategoria) {
		
		return categoriaProductoDao.findByNameCategoria(nombreCategoria);
	}*/

}
