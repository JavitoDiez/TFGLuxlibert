package com.gestorVentas.Controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	@GetMapping("/ventas")
	public String indexProveedores(Model model) {

		List<ProductoEnt> listadoProductos = productoService.findAll();
		model.addAttribute("productos", listadoProductos);
		model.addAttribute("listadoVentas", ventasService.findAll());

		return "ventas";
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

			}
		}

		return "redirect:/ventas";
	}

}
