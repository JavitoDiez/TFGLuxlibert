package com.gestorVentas.Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gestorVentas.Entidades.Compra;
import com.gestorVentas.Entidades.DetalleCompra;
import com.gestorVentas.Entidades.ProductoEnt;
import com.gestorVentas.Entidades.Venta;
import com.gestorVentas.Servicio.DetalleCompraService;
import com.gestorVentas.Servicio.ProductoService;
import com.gestorVentas.Servicio.VentasService;

@Controller
public class estadisticaController {

	@Autowired
	VentasService ventasService;

	@Autowired
	DetalleCompraService compraService;

	@Autowired
	ProductoService productoService;

	// DECLARO GLOBALES LAS LISTAS PARA HACER CALCULOS CON ELLAS

	@GetMapping("/estadisticas")
	public String getPieChart(Model model) {

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
		model.addAttribute("simboloPorcentaje", simboloPorcentaje);
		model.addAttribute("simboloEuro", simboloEuro);
		
		//model.addAttribute("chartData", ventasService.ingresosProductoMesActual());
		model.addAttribute("chartDataProductos",this.ingresosProductoMesActual());
		//model.addAttribute("datosGraficos", this.ingresoGastoTrimestre());
		
		return "estadisticas";
	}
	
	
	public Map<String, Double> ingresosProductoMesActual(){
		
		List<Venta> listadoVentas = ventasService.ventasPorProductos();
		
		Map<String, Double> datosGrafica = new TreeMap<>();
		
		for (Venta venta : listadoVentas) {
			
			datosGrafica.put(venta.getProducto().getNombreProducto(), venta.getImporteVenta());
		}
	
		return datosGrafica;
	}
	
	
	
	
	
	/*public Map<String, TreeMap<Double, Double>> ingresoGastoTrimestre() {
		
		List<Venta> listadoVentas = ventasService.findAll();
		
		List<DetalleCompra> listadoCompras = compraService.findAll();
		double totalComprasTrimestre1 = 0.0;
		double totalComprasTrimestre2 = 0.0;
		double totalComprasTrimestre3 = 0.0;
		double totalComprasTrimestre4 = 0.0;
		
		double totalVentasTrimestre1 = 0.0;
		double totalVentasTrimestre2 = 0.0;
		double totalVentasTrimestre3 = 0.0;
		double totalVentasTrimestre4 = 0.0;
		
		Map<String, TreeMap<Double,Double>> datosGrafico  =new TreeMap<>();
		
		TreeMap<Double,Double> ventasComprasTrimestres = new TreeMap<>();
	
		for (Venta venta : listadoVentas) {
			
			for (DetalleCompra compra : listadoCompras) {
				
				if(venta.getFechaVenta().getMonth()>=1 || venta.getFechaVenta().getMonth() <=3 ) {
					totalVentasTrimestre1 += venta.getImporteVenta();
					totalComprasTrimestre1 +=  compra.getImporteCompra();
					
					
				}else if (venta.getFechaVenta().getMonth()>=4 || venta.getFechaVenta().getMonth() <=6 ) {
					totalVentasTrimestre2 += venta.getImporteVenta();
					totalComprasTrimestre2 +=  compra.getImporteCompra();
					
					
				}else if (venta.getFechaVenta().getMonth()>=7 || venta.getFechaVenta().getMonth() <=9 ) {
					totalVentasTrimestre3 += venta.getImporteVenta();
					totalComprasTrimestre3 +=  compra.getImporteCompra();
					
				}else if (venta.getFechaVenta().getMonth()>=10 || venta.getFechaVenta().getMonth() <= 12 ) {
					
					totalVentasTrimestre4 += venta.getImporteVenta();
					totalComprasTrimestre4 +=  compra.getImporteCompra();
					
				}
				
				
			}
			
			
			
		}
		
		ventasComprasTrimestres.put(totalVentasTrimestre1, totalComprasTrimestre1) ;
		ventasComprasTrimestres.put(totalVentasTrimestre2, totalComprasTrimestre2) ;
		ventasComprasTrimestres.put(totalVentasTrimestre3, totalComprasTrimestre3) ;
		ventasComprasTrimestres.put(totalVentasTrimestre4, totalComprasTrimestre4) ;
		
		datosGrafico.put("Trimestre 1", ventasComprasTrimestres);
		datosGrafico.put("Trimestre 2", ventasComprasTrimestres);
		datosGrafico.put("Trimestre 3", ventasComprasTrimestres);
		datosGrafico.put("Trimestre 4", ventasComprasTrimestres);
		
		

		
		return datosGrafico;
	}*/
	
	public int porcentajeVentasActualAnterior() {
		
		int ventasActuales  = ventasService.ventasRealizadasMesActual();
		int ventasMesAnterior = ventasService.ventasRealizadasMesAnterior();
		
		
		return ((ventasActuales/ventasMesAnterior)*100)-100;
		
	}
	


	public Double beneficios() {
		
		double importe = ventasService.totalIngresosVentas() - compraService.totalGastosCompras();
		
		return Math.round(importe*100.0)/100.0;

	}

}
