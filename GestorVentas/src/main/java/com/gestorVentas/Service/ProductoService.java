package com.gestorVentas.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gestorVentas.Model.Producto;
import com.gestorVentas.Repository.IProductosRepository;

@Service
public class ProductoService implements IProductoService{

	@Autowired
	IProductosRepository productosRepository;

	@Override
	public Page<Producto> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		
		return productosRepository.findAll(pageable);
	}

	@Override
	public Producto insertarProducto(Producto productoEnt) {
		// TODO Auto-generated method stub
		return productosRepository.save(productoEnt);
	}

	@Override
	public void borrarProducto(Producto productoEnt) {
		// TODO Auto-generated method stub
		productosRepository.delete(productoEnt);
	}

	@Override
	public Optional<Producto> findById(int idProducto) {
		// TODO Auto-generated method stub
		return productosRepository.findById(idProducto);
	}

	@Override
	public Producto actualizarProducto(Producto productoEnt) {
		
		return productosRepository.save(productoEnt);
	}

	@Override
	public Producto findByName(String nombre) {
		// TODO Auto-generated method stub
		return productosRepository.findByName(nombre);
	}
	
	@Override
	public List<Producto> findListByName(String nombre) {
		// TODO Auto-generated method stub
		return (List<Producto>) productosRepository.findListByName(nombre);
	}

	@Override
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return productosRepository.findAll();
	}
	
	
	
}
