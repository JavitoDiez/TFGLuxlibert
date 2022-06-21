package com.gestorVentas.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestorVentas.Model.CategoriaProducto;
import com.gestorVentas.Model.Producto;
import com.gestorVentas.Service.CategoriaProductoService;
import com.gestorVentas.Service.ProductoService;

@Controller
public class ProductosControlador extends HttpServlet {

	@Autowired
	ProductoService productoService;

	@Autowired
	CategoriaProductoService categoriaProductoService;

	@PostMapping("/categorias")
	public String agregarCategoria(@RequestParam("nombreCategoria") String nombreCategoria) {

		CategoriaProducto nuevaCategoriaProducto = new CategoriaProducto(nombreCategoria);

		categoriaProductoService.insertarCategoria(nuevaCategoriaProducto);

		return "redirect:/productos";
	}

	@GetMapping("/productos")
	public String listadoProductos(Model model) {

		List<Producto> listaProductos = productoService.findAll();
		model.addAttribute("productos", listaProductos);
		System.out.println("listaPrdouctos: " + listaProductos.toString());

		List<CategoriaProducto> listaCategoria = categoriaProductoService.findAll();
		model.addAttribute("categorias", listaCategoria);

		System.out.println(listaCategoria);

		return "productos";
	}

	/*
	 * @GetMapping("/") public String listadoProductosPaginación (@RequestParam
	 * Map<String,Object> params,Model model) {
	 * 
	 * //CONDICIONAL int page=params.get("page") != null?
	 * Integer.valueOf(params.get("page").toString())-1:0;
	 * 
	 * PageRequest pageRequest = PageRequest.of(page, 5); Page<ProductoEnt>
	 * listaProductos = productoService.findAll(pageRequest);
	 * 
	 * int totalPaginas = listaProductos.getTotalPages(); if(totalPaginas > 0) {
	 * 
	 * List<Integer> paginas = IntStream.rangeClosed(1,
	 * totalPaginas).boxed().collect(Collectors.toList());
	 * 
	 * model.addAttribute("paginas", paginas); }
	 * 
	 * model.addAttribute("productos", listaProductos.getContent());
	 * System.out.println("listaPrdouctos: "+listaProductos.toString());
	 * 
	 * 
	 * List<CategoriaProducto> listaCategoria = categoriaProductoService.findAll();
	 * model.addAttribute("categorias", listaCategoria);
	 * 
	 * System.out.println(listaCategoria);
	 * 
	 * return "productos"; }
	 */

	@PostMapping("/productos")
	public String agregarProducto(@RequestParam("nombreProducto") String nombreProducto,
			@RequestParam("descripcion") String descripcion, @RequestParam("categoria") String categoria,
			@RequestParam("pvp") String pvp) {
		try {
			Double precioVenta = Double.parseDouble(pvp);
			CategoriaProducto categoriaObj = categoriaProductoService.findByName(categoria);
			Producto prodEnt = productoService.findByName(nombreProducto);
			if (prodEnt == null) {

				Double precioCompra = (double) (precioVenta * 0.80);
				Producto producto = new Producto(nombreProducto, descripcion, categoriaObj, precioVenta, precioCompra);
				System.out.println(producto.toString());
				productoService.insertarProducto(producto);
			}
			// EL PRECIO DE COMPRA ES UN 20% MENOS QUE EL DE VENTA
			return "redirect:/productos";
		} catch (Exception e) {
			// TODO: handle exception
			return "productos";
		}

	}

	@GetMapping("/productos/editar/{idProducto}")
	public String buscarModificar(@PathVariable("idProducto") Integer idProducto, Model model) {

		Producto productoModificar = productoService.findById(idProducto).get();
		model.addAttribute("productoModificar", productoModificar);

		System.out.println(productoModificar.toString());

		List<CategoriaProducto> listaCategoria = categoriaProductoService.findAll();
		model.addAttribute("categorias", listaCategoria);

		return "editarProducto";

	}

	@PostMapping("/productos/{idProducto}")
	public String modificarProducto(@PathVariable("idProducto") Integer idProducto,
			@ModelAttribute("ProductoEnt") Producto producto, @RequestParam("pvp") String pvp, Model model) {

		Double precioVenta = Double.parseDouble(pvp);
		Producto productoModificado = productoService.findById(idProducto).get();

		productoModificado.setNombreProducto(producto.getNombreProducto());
		// productoModificado.setCategoriaProducto(producto.getCategoriaProducto());
		productoModificado.setPrecioVenta(precioVenta);
		productoModificado.setDescripcion(producto.getDescripcion());
		productoModificado.setPrecioCompra(precioVenta*0.80);

		productoService.insertarProducto(productoModificado);

		return "redirect:/productos";
	}

	@GetMapping("/productos/eliminar/{idProducto}")
	public String eliminarProducto(@PathVariable("idProducto") Integer idProducto, Model model) {

		Producto productoEliminar = productoService.findById(idProducto).get();
		productoService.borrarProducto(productoEliminar);

		return "redirect:/productos";

	}

}
