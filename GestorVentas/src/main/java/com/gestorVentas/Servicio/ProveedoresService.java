package com.gestorVentas.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestorVentas.DAO.IProveedorRepository;
import com.gestorVentas.Entidades.ProductoEnt;
import com.gestorVentas.Entidades.Proveedor;

@Service
public class ProveedoresService implements IProveedoresService{
	
	@Autowired
	IProveedorRepository proveedorRepository;

	@Override
	public List<Proveedor> findAll() {
		
		return proveedorRepository.findAll();
	}

	@Override
	public Proveedor insertarProducto(Proveedor proveedor) {
		// TODO Auto-generated method stub
		return proveedorRepository.save(proveedor);
	}

	@Override
	public void borrarProducto(Proveedor proveedor) {
		// TODO Auto-generated method stub
		proveedorRepository.delete(proveedor);
	}

	@Override
	public Optional<Proveedor> findById(int idProveedor) {
		
		
		return proveedorRepository.findById(idProveedor);
	}

	@Override
	public Proveedor actualizarProducto(Proveedor proveedor) {
		
		return proveedorRepository.save(proveedor);
	}

	@Override
	public Proveedor findByName(String nombre) {
		// TODO Auto-generated method stub
		return proveedorRepository.findByName(nombre);
	}

}
