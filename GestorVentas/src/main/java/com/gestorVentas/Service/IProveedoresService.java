package com.gestorVentas.Service;

import java.util.List;
import java.util.Optional;

import com.gestorVentas.Model.Producto;
import com.gestorVentas.Model.Proveedor;

public interface IProveedoresService {


	public List<Proveedor> findAll();
	
	public Proveedor insertarProducto(Proveedor proveedor);
	
	public void borrarProducto(Proveedor proveedor);
	
	public Optional<Proveedor> findById(int idProveedor);
	
	public Proveedor actualizarProducto(Proveedor proveedor);
	
	public Proveedor findByName(String nombre);
	
}
