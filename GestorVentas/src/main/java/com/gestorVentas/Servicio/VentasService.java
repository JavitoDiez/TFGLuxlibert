package com.gestorVentas.Servicio;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gestorVentas.DAO.IVentasRepository;
import com.gestorVentas.Entidades.Venta;

@Service
public class VentasService implements IVentasService {

	@Autowired
	IVentasRepository ventasRepository;
	
	@Override
	public List<Venta> findAll() {
		// TODO Auto-generated method stub
		return ventasRepository.findAll();
	}

	@Override
	public List<Venta> findAllLimitFive() {
		// TODO Auto-generated method stub
		return ventasRepository.findAll();
	}

	@Override
	public Page<Venta> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return ventasRepository.findAll(pageable);
	}

	@Override
	public Venta realizarVenta(Venta venta) {
		// TODO Auto-generated method stub
		return ventasRepository.save(venta);
	}

	@Override
	public List<Venta> findByRangeDate(Date desde, Date hasta) {
		// TODO Auto-generated method stub
		return ventasRepository.findByRangeDate(desde, hasta);
	}

	@Override
	public List<Venta> ventasPorProductos() {
		
		
		
		
		return  ventasRepository.ventasPorProductos(); 
	}
	
	public Map<String, Double> ingresosProductoMesActual() {

		List<Venta> listadoVentas = ventasRepository.findAll();

		Date ahora = new Date();
		SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
		formateador.format(ahora);
		Calendar fechaActual = Calendar.getInstance();

		fechaActual.setTime(ahora);

		int mesActual = fechaActual.get(Calendar.MONTH);
		Map<String, Double> datosGrafica = new TreeMap<>();

		for (Venta venta : listadoVentas) {
			double importeTotalProducto = 0.0;
			if (venta.getFechaVenta().getMonth() == mesActual) {
				
				
				 importeTotalProducto = venta.getImporteVenta();
				

			}
			datosGrafica.put(venta.getProducto().getNombreProducto(), importeTotalProducto);

		}

		return datosGrafica;

	}

	public Double totalIngresosVentas() {
		List<Venta> listadoVentas = ventasRepository.findAll();

		double totalIngresosVenta = 0;

		for (Venta venta : listadoVentas) {

			totalIngresosVenta += venta.getImporteVenta() ;
		}

		return totalIngresosVenta;
	}
	
	public int ventasRealizadasMesActual() {

		List<Venta> listadoVentas = ventasRepository.findAll();

		Date ahora = new Date();
		SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
		formateador.format(ahora);
		Calendar fechaActual = Calendar.getInstance();

		fechaActual.setTime(ahora);

		int mesActual = fechaActual.get(Calendar.MONTH);
		//int mesAnterior = fechaActual.get(Calendar.MONTH - 1);
		//Map<String, Double> datosGrafica = new TreeMap<>();
		int ventasRealizadas = 0;
		for (Venta venta : listadoVentas) {
			
			if (venta.getFechaVenta().getMonth() == mesActual) {
					
				ventasRealizadas += 1;
			}
			
		}

		return ventasRealizadas;

	}
	
	public int ventasRealizadasMesAnterior() {

		List<Venta> listadoVentas = ventasRepository.findAll();

		Date ahora = new Date();
		SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
		formateador.format(ahora);
		Calendar fechaActual = Calendar.getInstance();

		fechaActual.setTime(ahora);

		int mesActual = fechaActual.get(Calendar.MONTH);
		int mesAnterior = mesActual-1;
		//Map<String, Double> datosGrafica = new TreeMap<>();
		int ventasRealizadas = 0;
		for (Venta venta : listadoVentas) {
			
			if (venta.getFechaVenta().getMonth() == mesAnterior) {
					
				ventasRealizadas += 1;
			}
			
		}

		return ventasRealizadas;

	}

	


}
