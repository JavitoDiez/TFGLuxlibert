package com.gestorVentas.Controller;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gestorVentas.Entidades.Venta;
import com.gestorVentas.Servicio.VentasService;

@Controller
public class estadisticaController {
	
	@Autowired
	VentasService ventasService;
	
	 @GetMapping("/estadisticas")
	    public String getPieChart(Model model) {
		 
		/*List<Venta> listadoVentas =  ventasService.findAll();
		
		for (Venta venta : listadoVentas) {
			
			Double ingresosTrimestral1 = venta.getImporteVenta()+venta.getImporteVenta();
			
		}*/
		 
		 
	        Map<String, Double> graphData = new TreeMap<>();
	        graphData.put("1º Trimestre", (double) 147);
	        graphData.put("2º Trimestre", (double) 1256);
	        graphData.put("3º Trimestre", (double) 3856);
	        graphData.put("4º Trimestre", (double) 19807);
	        
	        model.addAttribute("chartData", graphData);
	        return "estadisticas";
	    }
	
}
