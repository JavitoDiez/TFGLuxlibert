package com.gestorVentas.Servicio;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gestorVentas.Entidades.Compra;

public interface ICompraProductoService {

	
	public List<Compra>findAll();

	
	public Page<Compra>findAll (int pageNumber);
	
	public Compra realizarCompra(Compra compra);
	
	
	
}
