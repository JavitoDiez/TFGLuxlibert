package com.gestorVentas.Controller;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gestorVentas.Entidades.CategoriaProducto;
import com.gestorVentas.Entidades.DetalleCompra;
import com.gestorVentas.Entidades.ProductoEnt;
import com.gestorVentas.Entidades.Venta;
import com.gestorVentas.Servicio.ProductoService;
import com.gestorVentas.Servicio.VentasService;

@Controller
public class VentasController {

	@Autowired
	VentasService ventasService;

	@Autowired
	ProductoService productoService;

	/*@GetMapping("/ventas")
	public String indexProveedores(Model model) {

		List<ProductoEnt> listadoProductos = productoService.findAll();
		model.addAttribute("productos", listadoProductos);
		model.addAttribute("ventas", ventasService.findAll());

		return "ventas";
	}*/
	
	@PostMapping("/ventas")
	public String busquedaFechas(@RequestParam("desdeVenta") Date desde, @RequestParam("hastaVenta") Date hasta, Model model) {
	

	try {
		if (hasta != null && desde != null) {

			List<Venta> ventasEncontradas = ventasService.findByRangeDate(desde, hasta);
			System.out.println(ventasEncontradas.toString());
			if (ventasEncontradas.size() > 0) {
				String mensajeResultadoBueno = "Búsqueda Realizada correctamente";
				int numeroResultados = ventasEncontradas.size();
				model.addAttribute("mensajeResultadoVentas", mensajeResultadoBueno);
				model.addAttribute("numeroResultadosVentas", numeroResultados);
				model.addAttribute("ventas", ventasEncontradas);

			} else {
				String mensajeResultadoMalo = null;
				model.addAttribute("mensajeResultado", mensajeResultadoMalo);

			}
		}
		return "ventas";
	} catch (Exception e) {
		// TODO: handle exception
		return "redirect: /ventas";
	}

		
	}

	@PostMapping("/registrarVenta")
	public String registrarVenta(Model model, @RequestParam("fechaVenta") Date fechaVenta,
			@RequestParam("producto") String nombreProducto, @RequestParam("cantidad") int cantidad) {

		List<ProductoEnt> producto = productoService.findListByName(nombreProducto);
		
		int stockProducto = 0;
		for (ProductoEnt productoEnt : producto) {

			Double importeVenta = productoEnt.getPrecioVenta() * cantidad;
			stockProducto = productoEnt.getStock();
			model.addAttribute("stockProducto", stockProducto);
			model.addAttribute("cantidad", cantidad);
			
			if (cantidad <= stockProducto) {
				Venta venta = new Venta(importeVenta, fechaVenta, cantidad, productoEnt);

				productoEnt.setStock(productoEnt.getStock() - cantidad);

				productoService.insertarProducto(productoEnt);
				ventasService.realizarVenta(venta);

				model.addAttribute("venta", venta);
				model.addAttribute("mensaje","Se ha registrado la venta con éxito");

			}else {
				model.addAttribute("mensaje",null);
			}
		}

		return "redirect:/ventas";
	}
	
	
	@GetMapping("/ventas")
	public String listadoVentas(@RequestParam Map<String,Object> params,Model model){
		
		//CONDICIONAL 
				int page=params.get("page") != null? Integer.valueOf(params.get("page").toString())-1:0;
				
				PageRequest pageRequest = PageRequest.of(page, 5);
				Page<Venta> listaVentas = ventasService.findAll(pageRequest);
				
				int totalPaginas = listaVentas.getTotalPages();
				if(totalPaginas > 0) {
					
					List<Integer> paginas = IntStream.rangeClosed(1, totalPaginas).boxed().collect(Collectors.toList());
					
					model.addAttribute("paginas", paginas);
				}
				
				model.addAttribute("ventas", listaVentas.getContent());
				System.out.println("listaVentas: "+listaVentas.toString());
				

				
				return "ventas";
	}
	@GetMapping("/")
	public String listadoVentasPaginadas(@RequestParam Map<String,Object> params,Model model){
		
		//CONDICIONAL 
				int page=params.get("page") != null? Integer.valueOf(params.get("page").toString())-1:0;
				
				PageRequest pageRequest = PageRequest.of(page, 5);
				Page<Venta> listaVentas = ventasService.findAll(pageRequest);
				
				int totalPaginas = listaVentas.getTotalPages();
				if(totalPaginas > 0) {
					
					List<Integer> paginas = IntStream.rangeClosed(1, totalPaginas).boxed().collect(Collectors.toList());
					
					model.addAttribute("paginas", paginas);
				}
				
				model.addAttribute("ventas", listaVentas.getContent());
				System.out.println("listaVentas: "+listaVentas.toString());
				

				
				return "ventas";
	}

}
