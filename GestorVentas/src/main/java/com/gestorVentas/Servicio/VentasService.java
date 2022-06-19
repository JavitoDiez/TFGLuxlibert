package com.gestorVentas.Servicio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

		return ventasRepository.ventasPorProductos();
	}

	public Map<String, Double> ingresosProductoMesActual() {

		List<Venta> listadoVentas = ventasRepository.findAll();
		List<Integer> listadoVentasTotales = new ArrayList<Integer>();

		Date ahora = new Date();
		SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
		formateador.format(ahora);
		Calendar fechaActual = Calendar.getInstance();

		fechaActual.setTime(ahora);

		int mesActual = fechaActual.get(Calendar.MONTH);
		Map<String, Double> datosGrafica = new TreeMap<>();
		double cantidadTotal = 0.0;
		double importe = 0.0;

		/*
		 * for (Venta venta : listadoVentas) { int id =
		 * venta.getProducto().getIdProducto() ;
		 * 
		 * if(venta.getProducto().getIdProducto() ==
		 * venta.getProducto().getIdProducto()|| venta.getFechaVenta().getMonth() ==
		 * mesActual) { cantidadTotal += venta.getCantidadProductoVendido();
		 * datosGrafica.put(venta.getProducto().getNombreProducto(), cantidadTotal);
		 * 
		 * }
		 * 
		 * }
		 */
		for (Venta venta : listadoVentas) {
			int id = venta.getProducto().getIdProducto();
			if (mesActual == venta.getFechaVenta().getMonth()) {
				if (listadoVentasTotales.contains(id) == false) {

					listadoVentasTotales.add(id);

				}
			}
		}
		System.out.println("LISTADO ID; " + listadoVentasTotales.toString());
		List<Double> listadoTotales = new ArrayList<Double>();
		for (int i = 0; i < listadoVentasTotales.size(); i++) {
			importe = 0;
			String nombreProducto = "";
			for (Venta venta2 : listadoVentas) {
				if (listadoVentasTotales.get(i) == venta2.getProducto().getIdProducto()) {
					importe += venta2.getImporteVenta();
					nombreProducto = venta2.getProducto().getNombreProducto();
				}

			}
			datosGrafica.put(nombreProducto, importe);
			System.out.println(datosGrafica.toString());
			listadoTotales.add(importe);
		}

		System.out.println(listadoTotales.toString());

		return datosGrafica;

	}

	

	public Map<String, Integer> productosMasVendidos() {

		List<Venta> listadoVentas = ventasRepository.findAll();
		List<Integer> listadoVentasTotales = new ArrayList<Integer>();

		// Date ahora = new Date();
		Map<String, Integer> datosGrafica = new TreeMap<>();

		int cantidad = 0;

		for (Venta venta : listadoVentas) {
			int id = venta.getProducto().getIdProducto();
			if (listadoVentasTotales.contains(id) == false) {
				listadoVentasTotales.add(id);
			}

		}
		System.out.println("LISTADO ID; " + listadoVentasTotales.toString());
		List<Integer> listadoTotales = new ArrayList<Integer>();
		for (int i = 0; i < listadoVentasTotales.size(); i++) {
			cantidad = 0;
			String nombreProducto = "";
			for (Venta venta2 : listadoVentas) {
				if (listadoVentasTotales.get(i) == venta2.getProducto().getIdProducto()) {
					cantidad += venta2.getCantidadProductoVendido();
					nombreProducto = venta2.getProducto().getNombreProducto();
				}

			}
			datosGrafica.put(nombreProducto, cantidad);
			System.out.println(datosGrafica.toString());
			listadoTotales.add(cantidad);
		}

		System.out.println(listadoTotales.toString());

		return datosGrafica;

	}

	public Map<String, Double> ingresosProductoByMes(Date date) {

		List<Venta> listadoVentas = ventasRepository.findAll();
		List<Integer> listadoVentasTotales = new ArrayList<Integer>();

		// Date ahora = new Date();
		SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
		formateador.format(date);
		Calendar fechaSeleccionadaUsuario = Calendar.getInstance();

		fechaSeleccionadaUsuario.setTime(date);

		int mesElegido = fechaSeleccionadaUsuario.get(Calendar.MONTH);

		Map<String, Double> datosGrafica = new TreeMap<>();
		double cantidadTotal = 0.0;
		double importe = 0.0;

		for (Venta venta : listadoVentas) {
			int id = venta.getProducto().getIdProducto();
			if (mesElegido == venta.getFechaVenta().getMonth()) {
				if (listadoVentasTotales.contains(id) == false) {
					listadoVentasTotales.add(id);

				}
			}
		}
		System.out.println("LISTADO ID; " + listadoVentasTotales.toString());
		List<Double> listadoTotales = new ArrayList<Double>();
		for (int i = 0; i < listadoVentasTotales.size(); i++) {
			importe = 0;
			String nombreProducto = "";
			for (Venta venta2 : listadoVentas) {
				if (listadoVentasTotales.get(i) == venta2.getProducto().getIdProducto()) {
					importe += venta2.getImporteVenta();
					nombreProducto = venta2.getProducto().getNombreProducto();
				}

			}
			datosGrafica.put(nombreProducto, importe);
			System.out.println(datosGrafica.toString());
			listadoTotales.add(importe);
		}

		System.out.println(listadoTotales.toString());

		return datosGrafica;

	}

	public Double totalIngresosVentas() {
		List<Venta> listadoVentas = ventasRepository.findAll();

		double totalIngresosVenta = 0;

		for (Venta venta : listadoVentas) {

			totalIngresosVenta += venta.getImporteVenta();
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
		// int mesAnterior = fechaActual.get(Calendar.MONTH - 1);
		// Map<String, Double> datosGrafica = new TreeMap<>();
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
		int mesAnterior = mesActual - 1;
		// Map<String, Double> datosGrafica = new TreeMap<>();
		int ventasRealizadas = 0;
		for (Venta venta : listadoVentas) {

			if (venta.getFechaVenta().getMonth() == mesAnterior) {

				ventasRealizadas += 1;
			}

		}
		System.out.println("Ventas Mes anterior" + ventasRealizadas);
		return ventasRealizadas;

	}

}
