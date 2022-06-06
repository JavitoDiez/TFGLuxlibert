package com.gestorVentas.Servicio;

import java.util.List;
import java.util.Optional;

import com.gestorVentas.Entidades.*;

public interface IDetalleCompraService {

	public List<DetalleCompra> findAll();
	
	public List<DetalleCompra>insertar(List<DetalleCompra> detalleCompra);
	
	public void elimina(DetalleCompra detalleCompra);
	
	public Optional<DetalleCompra> findById(int idDetalleCompra);
	

}
