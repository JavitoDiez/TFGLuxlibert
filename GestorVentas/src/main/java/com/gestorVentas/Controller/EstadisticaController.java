package com.gestorVentas.Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gestorVentas.Model.DetalleCompra;
import com.gestorVentas.Model.Producto;
import com.gestorVentas.Model.Venta;
import com.gestorVentas.Service.DetalleCompraService;
import com.gestorVentas.Service.ProductoService;
import com.gestorVentas.Service.VentasService;

@Controller
public class EstadisticaController {

	@Autowired
	VentasService ventasService;

	@Autowired
	DetalleCompraService compraService;

	@Autowired
	ProductoService productoService;

	// DECLARO GLOBALES LAS LISTAS PARA HACER CALCULOS CON ELLAS

	
	
	@GetMapping("/estadisticas")
	public String dashboardPrincipal(Model model) {

		// model.addAttribute(null, listadoVentas);

		/*
		 * Map<String, Double> graphData = new TreeMap<>();
		 * graphData.put("1º Trimestre", (double) 147); graphData.put("2º Trimestre",
		 * (double) 1256); graphData.put("3º Trimestre", (double) 3856);
		 * graphData.put("4º Trimestre", (double) 19807);
		 */
		

		
		
		String simboloEuro = " €";
		
		String simboloPorcentaje = " %";

		model.addAttribute("ingresosVentas", ventasService.totalIngresosVentas());
		model.addAttribute("beneficios", this.beneficios());
		model.addAttribute("ventasRealizadas", ventasService.ventasRealizadasMesActual());
		model.addAttribute("ventasRealizadasMesAnterior", this.porcentajeVentasActualAnterior());
		model.addAttribute("ProductoMasVendido", this.productoMasVendido());
		model.addAttribute("CantidadProductoMasVendido", this.CantidadproductoMasVendido());
		model.addAttribute("simboloPorcentaje", simboloPorcentaje);
		model.addAttribute("simboloEuro", simboloEuro);
		
		model.addAttribute("chartData", ventasService.ingresosProductoMesActual());
		model.addAttribute("chartDataProductos",this.ingresosProductoMesActual());
		model.addAttribute("cantidadVendida", ventasService.productosMasVendidos());
		
		
		
		return "estadisticas";
	}
	
	@GetMapping("/estadisticas/productosMasVendidos")
	public String graficoProductosVendidos(Model model) {


		
		model.addAttribute("cantidadVendida", ventasService.productosMasVendidos());
		
		return "iframeProductosMasVendidos";
	}
	
	
	public Map<String, Double> ingresosProductoMesActual(){
		
		List<Venta> listadoVentas = ventasService.ventasPorProductos();
		
		Map<String, Double> datosGrafica = new TreeMap<>();
		
		for (Venta venta : listadoVentas) {
			
			datosGrafica.put(venta.getProducto().getNombreProducto(), venta.getImporteVenta());
		}
	
		return datosGrafica;
	}
	
	
	public String productoMasVendido() {
		
	Map<String, Integer> mapaProductosVendidos = ventasService.productosMasVendidos();	
	 Entry<String, Integer> maxEntry = null;
	    Integer max = Collections.max(mapaProductosVendidos.values());

	    for(Entry<String, Integer> entry : mapaProductosVendidos.entrySet()) {
	        Integer value = entry.getValue();
	        if(null != value && max == value) {
	            maxEntry = entry;
	        }
	    }
	  String  nombreProducto= maxEntry.getKey()+" ";
	
	  
	    return nombreProducto;
		
		
	}
	
	public Integer CantidadproductoMasVendido() {
		
		Map<String, Integer> mapaProductosVendidos = ventasService.productosMasVendidos();	
		 Entry<String, Integer> maxEntry = null;
		    Integer max = Collections.max(mapaProductosVendidos.values());

		    for(Entry<String, Integer> entry : mapaProductosVendidos.entrySet()) {
		        Integer value = entry.getValue();
		        if(null != value && max == value) {
		            maxEntry = entry;
		        }
		    }
		 
		  
		  
		    return maxEntry.getValue();
			
			
		}
	
	public int porcentajeVentasActualAnterior() {
		
		int ventasActuales  = ventasService.ventasRealizadasMesActual();
		int ventasMesAnterior = ventasService.ventasRealizadasMesAnterior();
		
		
		return ventasActuales- ventasMesAnterior;
		
	}
	


	public Double beneficios() {
		
		double importe = ventasService.totalIngresosVentas() - compraService.totalGastosCompras();
		
		return Math.round(importe*100.0)/100.0;

	}

}
