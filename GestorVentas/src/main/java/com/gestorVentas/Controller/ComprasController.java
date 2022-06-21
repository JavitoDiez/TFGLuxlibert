package com.gestorVentas.Controller;

import java.lang.reflect.Array;
import java.sql.Date;
import java.util.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.gestorVentas.Model.*;
import com.gestorVentas.Service.*;

@Controller
public class ComprasController {

	private static final Producto ProductoEnt = null;
	
	@Autowired
	private ProveedoresService proveedoresService;

	@Autowired
	private ProductoService productoService;

	@Autowired
	private DetalleCompraService detalleService;
	
	@Autowired
	private SendEmailService emailService;

	@GetMapping("/compras")
	public String listadoComprasPrincipal(Model model) {

		model.addAttribute("compras", detalleService.findAllLimitFive());

		this.rellenarCombos(model);

		return "compras";

	}



	@PostMapping("/realizarCompra")
	public String hacerCompra(@RequestParam("fechaCompra") Date fechaCompra,
			@RequestParam("producto") String nombreProducto, @RequestParam("proveedor") String nombreProveedor,
			@RequestParam("cantidad") int cantidad, @RequestParam("importe") String importe) {

		Double importeCompra = Double.parseDouble(importe);

		Proveedor proveedor = proveedoresService.findByName(nombreProveedor);

		Producto producto = productoService.findByName(nombreProducto);

		System.out.println("MATERIA PRIMA :" + producto.toString());

		producto.setStock(cantidad + producto.getStock());
		System.out.println("STOCCK" + producto.getStock());

		// materiaPrima.setStock(cantidad);

		// Compra compraRealizada = new Compra(cantidad, materiaPrima, proveedor,
		// importeCompra, fechaCompra);

		// System.out.println(compraRealizada.toString());
		// comprasProductoService.realizarCompra(compraRealizada);

		return "redirect:/compras";
	}

	@PostMapping("/compras/registroCompra/añadirCarrito")
	public String añadirCarrito(@RequestParam("fechaCompra") Date fechaCompra,
			@RequestParam("producto") String nombreProducto, @RequestParam("proveedor") String nombreProveedor,
			@RequestParam("cantidad") int cantidad, Model model,
			HttpServletRequest request, HttpSession session) {

		List<CarritoCompras> carrito = (List<CarritoCompras>) session.getAttribute("carrito");

		Proveedor proveedor = proveedoresService.findByName(nombreProveedor);

		List<Producto> producto = productoService.findListByName(nombreProducto);

		for (Producto productoEnt : producto) {

			Double importeCompra = productoEnt.getPrecioCompra()*cantidad;
			
			System.out.println("MATERIA PRIMA :" + producto.toString());

			carrito.add(new CarritoCompras(productoEnt, cantidad, proveedor, fechaCompra, importeCompra));

			System.out.println("carrito" + request.getAttribute("carrito"));

			request.setAttribute("carrito", carrito);

		}
		this.rellenarCombos(model);

		return "registroCompra";
	}

	@GetMapping("/compras/registroCompra")
	public String carritoCompras(Model model, HttpServletRequest request, HttpSession sesion) {

		sesion.setAttribute("carrito", new ArrayList<CarritoCompras>());

		this.rellenarCombos(model);

		return "registroCompra";
	}

	@PostMapping("/compras")
	public String busquedaCompras(@RequestParam("desde") Date desde, @RequestParam("hasta") Date hasta, Model model,
			RedirectAttributes redirectAttrs) {

		try {
			if (hasta != null && desde != null) {

				List<DetalleCompra> comprasEncontradas = detalleService.findByRangeDate(desde, hasta);
				System.out.println(comprasEncontradas.toString());
				if (comprasEncontradas.size() > 0) {
					String mensajeResultadoBueno = "Búsqueda Realizada correctamente";
					int numeroResultados = comprasEncontradas.size();
					model.addAttribute("mensajeResultado", mensajeResultadoBueno);
					model.addAttribute("numeroResultados", numeroResultados);
					model.addAttribute("compras", comprasEncontradas);

				} else {
					String mensajeResultadoMalo = null;
					model.addAttribute("mensajeResultado", mensajeResultadoMalo);

				}
			}
			return "compras";
		} catch (Exception e) {
			// TODO: handle exception
			return "redirect: /compras";
		}

	}
	
	
	@PostMapping("/findByProducto")
	public String BusquedaPorProducto (@RequestParam("producto") String nombreProducto,Model model) {
		
		Producto producto = productoService.findByName(nombreProducto);
		
		System.out.println("BUSQUEDA PROD "+ producto.toString());
		
		List<DetalleCompra> listadoCompras = detalleService.findByProduct(producto);
		
		System.out.println("LISTADO COMPRAS POR PROD"+ listadoCompras.toString());
		
		model.addAttribute("compras",listadoCompras);
		
		
		return "compras";
	}

	public Producto editarStockProducto() {

		return ProductoEnt;
	}

	public void rellenarCombos(Model model) {

		List<Producto> listadoProductos = productoService.findAll();

		model.addAttribute("productos", listadoProductos);

		List<Proveedor> listadoProveedores = proveedoresService.findAll();
		model.addAttribute("proveedores", listadoProveedores);
	}

	private ArrayList<CarritoCompras> obtenerCarrito(HttpServletRequest request) {

		ArrayList<CarritoCompras> carrito = (ArrayList<CarritoCompras>) request.getSession().getAttribute("carrito");
		
		if (carrito == null) {

			carrito = new ArrayList<>();
		}
		return carrito;
	}

	@PostMapping("/compras/compraRealizada")
	public String compraRealizada(HttpServletRequest request, HttpSession sesion, Model model) {

		System.out.println("Carrito de compra" + sesion.getAttribute("carrito"));

		List<CarritoCompras> carrito = (List<CarritoCompras>) sesion.getAttribute("carrito");

		List<DetalleCompra> detalle = new ArrayList<DetalleCompra>();

		double importeTotalCompra;

		try {

			if (carrito.isEmpty() == true) {

				return "redirect:/compras/registroCompra";

			} else {

				for (CarritoCompras carritoCompras : carrito) {
					// Double importeCompra = carritoCompras.getImporte()+
					// carritoCompras.getImporte();

					// compra.setImporteCompra(importeCompra);

					DetalleCompra detalleCompra = new DetalleCompra();

					Producto producto = carritoCompras.getProductoEnt();

					detalleCompra.setProductos(carritoCompras.getProductoEnt());
					detalleCompra.setProveedores(carritoCompras.getProveedor());
					detalleCompra.setFechaCompra(carritoCompras.getFecha());
					detalleCompra.setCantidad(carritoCompras.getCantidad());
					detalleCompra.setImporteCompra(producto.getPrecioCompra() * carritoCompras.getCantidad());
					System.out.println(detalleCompra.toString());
					
					// IMPORTE TOTAL

					importeTotalCompra = carritoCompras.getImporte() + carritoCompras.getImporte();
					
					

					detalle.add(detalleCompra);

					model.addAttribute("detalleCompra", detalleCompra);

					// Compra compra = new Compra(importeTotalCompra, detalleCompra);
					
					detalleService.insertar(detalle);

					System.out.println(detalle.toString());
					producto.setStock(producto.getStock() + carritoCompras.getCantidad());
					productoService.actualizarProducto(producto);
					
					//emailService.sendEmail(producto.getPrecioCompra() * carritoCompras.getCantidad());

				}
			}
		} catch (Exception e) {

		}

		

		// comprasProductoService.realizarCompra(compra);

		return "redirect:/compras";

	}
	

	
}

