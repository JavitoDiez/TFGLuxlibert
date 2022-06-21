package com.gestorVentas.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gestorVentas.Model.Venta;

public interface IVentasService {

	public List<Venta>findAll();
	
	public List<Venta>findAllLimitFive();
	
	public Page<Venta>findAll (Pageable pageable);
	
	public Venta realizarVenta(Venta venta);
	
	public List<Venta> findByRangeDate(Date desde, Date hasta);
	
	public List<Venta> ventasPorProductos();
	
	public Map<String, Double> ingresosProductoMesActual();
	
	Double totalIngresosVentas();
	
}
