package com.gestorVentas.Controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gestorVentas.Entidades.*;
import com.gestorVentas.Servicio.*;
import com.gestorVentas.Servicio.ComprasProductoService;
import com.gestorVentas.Servicio.MateriaPrimaService;
import com.gestorVentas.Servicio.ProveedoresService;

@Controller
public class ComprasController {

	private static final ProductoEnt ProductoEnt = null;
	@Autowired
	private ComprasProductoService comprasProductoService;
	@Autowired
	private MateriaPrimaService materiaPrimaService;

	@Autowired
	private ProveedoresService proveedoresService;

	@GetMapping("/compras")
	public String listadoComprasPrincipal(Model model){
		
		
		List<Compra> listadoCompras = comprasProductoService.findAllLimitFive();
		model.addAttribute("compras", listadoCompras);
		
		List<MateriaPrima> listadoMaterias = materiaPrimaService.findAll();

		model.addAttribute("materiasPrimas", listadoMaterias);

		List<Proveedor> listadoProveedores = proveedoresService.findAll();
		model.addAttribute("proveedores", listadoProveedores);
		
		
		
		return "compras";
		
	}
	
	
	
	
	/*@GetMapping("/compras/page/{pageCompra}")
	public String listadoCompras(@PathVariable("pageCompra") int currentPage,Model model){
		
		
		Page<Compra> listaCompras = comprasProductoService.findAll(currentPage);
		
		 int totalPages = listaCompras.getTotalPages();
		 long totalItems = listaCompras.getTotalElements();
		
		model.addAttribute("compras", listaCompras.getContent());
		model.addAttribute("totalPages", totalPages);
	    model.addAttribute("totalItems", totalItems);
		
		System.out.println("listaCompra: "+listaCompras.toString());
		
		
		
		List<MateriaPrima> listadoMaterias = materiaPrimaService.findAll();

		model.addAttribute("materiasPrimas", listadoMaterias);

		List<Proveedor> listadoProveedores = proveedoresService.findAll();
		model.addAttribute("proveedores", listadoProveedores);
		
	
		
		return "/compras";
		
	}*/
	
	
	

	@PostMapping("/realizarCompra")
	public String hacerCompra(@RequestParam("fechaCompra") Date fechaCompra,
			@RequestParam("materiaPrima") String nombreMateriaPrima, @RequestParam("proveedor") String nombreProveedor,
			@RequestParam("cantidad") int cantidad, @RequestParam("importe") String importe) {

		Double importeCompra = Double.parseDouble(importe);

		Proveedor proveedor = proveedoresService.findByName(nombreProveedor);

		MateriaPrima materiaPrima = materiaPrimaService.findByName(nombreMateriaPrima);
		
		if(materiaPrima.getNombre().equals("Piel cocodrilo") ) {
			
			
			
		}
		System.out.println("MATERIA PRIMA :"+ materiaPrima.toString());
		
		materiaPrima.setStock(cantidad + materiaPrima.getStock());
		System.out.println("STOCCK" + materiaPrima.getStock());
		//materiaPrima.setStock(cantidad);

		Compra compraRealizada = new Compra(cantidad, materiaPrima, proveedor, importeCompra, fechaCompra);

		System.out.println(compraRealizada.toString());
		comprasProductoService.realizarCompra(compraRealizada);

		return "redirect:/compras";
	}

	@GetMapping("/compras/registroCompra")
	public String carritoCompras(Model model) {

		List<Compra> listadoCompras = comprasProductoService.findAll();
		model.addAttribute("compras", listadoCompras);
		System.out.println(listadoCompras);

		List<MateriaPrima> listadoMaterias = materiaPrimaService.findAll();

		model.addAttribute("materiasPrimas", listadoMaterias);

		List<Proveedor> listadoProveedores = proveedoresService.findAll();
		model.addAttribute("proveedores", listadoProveedores);

		return "registroCompra";
	}

	
	@PostMapping("/compras/registroCompra")
	public String añadirCarrito(@RequestParam("fechaCompra") Date fechaCompra,
			@RequestParam("materiaPrima") String nombreMateriaPrima, @RequestParam("proveedor") String nombreProveedor,
			@RequestParam("cantidad") int cantidad, @RequestParam("importe") String importe, Model model) {

		Double importeCompra = Double.parseDouble(importe);

		Proveedor proveedor = proveedoresService.findByName(nombreProveedor);

		MateriaPrima materiaPrima = materiaPrimaService.findByName(nombreMateriaPrima);

		ArrayList<Compra> carritoCompra = new ArrayList<>();

		Compra compra = new Compra(cantidad, materiaPrima, proveedor, importeCompra, fechaCompra);

		carritoCompra.add(compra);
		System.out.println(carritoCompra.toString());

		model.addAttribute("carritoCompra", carritoCompra);

		return "redirect:/compras/registroCompra";
	}
	
	

	@PostMapping("/compras")
	public String busquedaCompras(@RequestParam("desde") Date desde, @RequestParam("hasta") Date hasta, Model model,
			RedirectAttributes redirectAttrs) {

		
		
		try {
			if (hasta != null && desde != null) {

				List<Compra> comprasEncontradas = comprasProductoService.findByRangeDate(desde, hasta);
				System.out.println(comprasEncontradas.toString());
				if (comprasEncontradas.size() > 0) {
					String mensajeResultadoBueno = "Búsqueda Realizada correctamente";
					model.addAttribute("mensajeResultado", mensajeResultadoBueno);

					model.addAttribute("compras", comprasEncontradas);

				} else {
					String mensajeResultadoMalo = "No se ha encontrado nada";
					model.addAttribute("mensajeResultado", mensajeResultadoMalo);

				}
			} 
			return "compras";
		} catch (Exception e) {
			// TODO: handle exception
			return "redirect: /compras";
		}

	}
	
	public ProductoEnt editarStockProducto() {
		
		
		
		
		return ProductoEnt;
	}
}
