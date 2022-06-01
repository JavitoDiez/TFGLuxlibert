package com.gestorVentas.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gestorVentas.DAO.IProductosRepository;
import com.gestorVentas.Entidades.ProductoEnt;

@Service
public class ProductoService implements IProductoService{

	@Autowired
	IProductosRepository productosRepository;

	@Override
	public Page<ProductoEnt> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		
		return productosRepository.findAll(pageable);
	}

	@Override
	public ProductoEnt insertarProducto(ProductoEnt productoEnt) {
		// TODO Auto-generated method stub
		return productosRepository.save(productoEnt);
	}

	@Override
	public void borrarProducto(ProductoEnt productoEnt) {
		// TODO Auto-generated method stub
		productosRepository.delete(productoEnt);
	}

	@Override
	public Optional<ProductoEnt> findById(int idProducto) {
		// TODO Auto-generated method stub
		return productosRepository.findById(idProducto);
	}

	@Override
	public ProductoEnt actualizarProducto(ProductoEnt productoEnt) {
		
		return productosRepository.save(productoEnt);
	}

	@Override
	public ProductoEnt findByName(String nombre) {
		// TODO Auto-generated method stub
		return productosRepository.findByName(nombre);
	}

	@Override
	public List<ProductoEnt> findAll() {
		// TODO Auto-generated method stub
		return productosRepository.findAll();
	}
	
	
	
}
