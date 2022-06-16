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

import com.gestorVentas.Entidades.CategoriaProducto;
import com.gestorVentas.Entidades.MateriaPrima;
import com.gestorVentas.Entidades.ProductoEnt;
import com.gestorVentas.Servicio.CategoriaProductoService;
import com.gestorVentas.Servicio.MateriaPrimaService;
import com.gestorVentas.Servicio.ProductoService;


@Controller
public class ProductosControlador extends HttpServlet{

	@Autowired
	ProductoService productoService;
	
	@Autowired
	CategoriaProductoService categoriaProductoService;
	
	@Autowired
	MateriaPrimaService materiaPrimaService;
	
	
	@GetMapping("/productos/materiasPrimas")
	public String listadoMateriaPrima (Model model) {
		
		List<MateriaPrima> listaMateriaPrima  = materiaPrimaService.findAll();
		model.addAttribute("materiasPrimas", listaMateriaPrima);
		System.out.println(listaMateriaPrima);
	
		
		return "materiasPrimas";
	}
	
	
	@PostMapping("/productos/materiasPrimas")
	public String agregarMateriaPrima(@RequestParam("nombreMateriaPrima") String nombre) {
		
		MateriaPrima materiaPrima = new MateriaPrima(nombre);
		
		materiaPrimaService.insertarMateriaPrima(materiaPrima);
		
		return "redirect:/productos/materiasPrimas";
	}
	
	@PostMapping("/categorias")
	public String agregarCategoria(@RequestParam("nombreCategoria") String nombreCategoria) {
		
		CategoriaProducto nuevaCategoriaProducto = new CategoriaProducto(nombreCategoria);
		
		categoriaProductoService.insertarCategoria(nuevaCategoriaProducto);
		
		return "redirect:/productos";
	}
	
	
	@GetMapping("/productos" )
	public String listadoProductos(Model model){
		
			
				List<ProductoEnt> listaProductos = productoService.findAll();
				model.addAttribute("productos", listaProductos);
				System.out.println("listaPrdouctos: "+listaProductos.toString());

				
				List<CategoriaProducto> listaCategoria  = categoriaProductoService.findAll();
				model.addAttribute("categorias", listaCategoria);
				
				System.out.println(listaCategoria);
				
				return "productos";
	}
	
	/*@GetMapping("/")
	public String listadoProductosPaginación (@RequestParam Map<String,Object> params,Model model) {
		
		//CONDICIONAL 
		int page=params.get("page") != null? Integer.valueOf(params.get("page").toString())-1:0;
		
		PageRequest pageRequest = PageRequest.of(page, 5);
		Page<ProductoEnt> listaProductos = productoService.findAll(pageRequest);
		
		int totalPaginas = listaProductos.getTotalPages();
		if(totalPaginas > 0) {
			
			List<Integer> paginas = IntStream.rangeClosed(1, totalPaginas).boxed().collect(Collectors.toList());
			
			model.addAttribute("paginas", paginas);
		}
		
		model.addAttribute("productos", listaProductos.getContent());
		System.out.println("listaPrdouctos: "+listaProductos.toString());
		
		
		List<CategoriaProducto> listaCategoria  = categoriaProductoService.findAll();
		model.addAttribute("categorias", listaCategoria);
		
		System.out.println(listaCategoria);
		
		return "productos";
	}*/
	

	
	
	
	@PostMapping("/productos")
	public String agregarProducto(  @RequestParam("nombreProducto") String nombreProducto,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("categoria") String categoria,
            @RequestParam("pvp") String pvp) {
	
		Double precioVenta = Double.parseDouble(pvp);
		CategoriaProducto categoriaObj = categoriaProductoService.findByName(categoria);
		
		//EL PRECIO DE COMPRA ES UN 20% MENOS QUE EL DE VENTA
		Double precioCompra = (double) (precioVenta * 0.80);
		
		ProductoEnt producto = new ProductoEnt(nombreProducto,descripcion,categoriaObj,precioVenta,precioCompra);
		System.out.println(producto.toString());
		productoService.insertarProducto(producto);
		
		return "redirect:/productos";
	}
	
	
	@GetMapping("/productos/editar/{idProducto}")
	public String buscarModificar(@PathVariable("idProducto")Integer idProducto, Model model) {
		
		
		ProductoEnt productoModificar = productoService.findById(idProducto).get();
		model.addAttribute("productoModificar",productoModificar);
		
		System.out.println(productoModificar.toString());
		
		List<CategoriaProducto> listaCategoria  = categoriaProductoService.findAll();
		model.addAttribute("categorias", listaCategoria);
		
		
		return "editarProducto";
		
	}
	
	@PostMapping("/productos/{idProducto}")
	public String modificarProducto(@PathVariable("idProducto")Integer idProducto,
            @ModelAttribute("ProductoEnt") ProductoEnt producto,  @RequestParam("pvp") String pvp, Model model) {
	
		Double precioVenta = Double.parseDouble(pvp);		
		ProductoEnt productoModificado = productoService.findById(idProducto).get();
		
		productoModificado.setNombreProducto(producto.getNombreProducto());
		//productoModificado.setCategoriaProducto(producto.getCategoriaProducto());
		productoModificado.setPrecioVenta(precioVenta);
		productoModificado.setDescripcion(producto.getDescripcion());
		
		productoService.insertarProducto(productoModificado);
		
		return "redirect:/productos";
	}
	
	

	@GetMapping("/productos/eliminar/{idProducto}")
	public String eliminarProducto(@PathVariable("idProducto")Integer idProducto, Model model) {
		
		
		ProductoEnt productoEliminar = productoService.findById(idProducto).get();
		productoService.borrarProducto(productoEliminar);
		
		
		return "redirect:/productos";
		
	}
	
}
