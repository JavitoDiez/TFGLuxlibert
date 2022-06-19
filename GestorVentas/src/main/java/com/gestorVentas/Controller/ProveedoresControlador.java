package com.gestorVentas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gestorVentas.Entidades.CategoriaProducto;
import com.gestorVentas.Entidades.Producto;
import com.gestorVentas.Entidades.Proveedor;
import com.gestorVentas.Servicio.ProveedoresService;

@Controller
public class ProveedoresControlador {

	@Autowired
	ProveedoresService proveedoresService;
	
	@GetMapping("/proveedores")
	public String indexProveedores(Model model) {
		
		
		
		model.addAttribute("listaProveedores", proveedoresService.findAll());
		
		
		return "proveedores";
	}
	
	@PostMapping("/proveedores")
	public String agregarProducto(  @RequestParam("nombreProveedor") String nombreProveedor,
            @RequestParam("telefono") String telefono,
            @RequestParam("correo") String correo,
            @RequestParam("direccion") String direccion) {

		Proveedor proovedor = new Proveedor(nombreProveedor,direccion,telefono,correo);
		System.out.println(proovedor.toString());
		proveedoresService.insertarProducto(proovedor);
		
		return "redirect:/proveedores";
	}
	
	
	@GetMapping("/proveedores/eliminar/{idProveedor}")
	public String eliminarProducto(@PathVariable("idProveedor")Integer idProveedor, Model model) {
		
		
		
		Proveedor proveedorEliminar = proveedoresService.findById(idProveedor).get();
		proveedoresService.borrarProducto(proveedorEliminar);
		
		
		return "redirect:/proveedores";
		
	}
	
	
	@GetMapping("/proveedores/editar/{idProveedor}")
	public String buscarModificar(@PathVariable("idProveedor")Integer idProveedor, Model model) {
		
		
		Proveedor proveedorModificar = proveedoresService.findById(idProveedor).get();
		model.addAttribute("proveedorModificar",proveedorModificar);
		
		System.out.println(proveedorModificar.toString());
		
		return "editarProveedor";
		
	}
	
	@PostMapping("/proveedores/{idProveedor}")
	public String modificarProducto(@PathVariable("idProveedor")Integer idProveedor,
            @ModelAttribute("Proveedor") Proveedor proveedor, Model model) {
	
		//int idProveedorint = Integer.parseInt(idProveedor);
		
		Proveedor proveedorModificar = proveedoresService.findById(idProveedor).get();
		
		proveedorModificar.setNombreProveedor(proveedor.getNombreProveedor());
	
		proveedorModificar.setCorreo(proveedor.getCorreo());
		proveedorModificar.setTelefono(proveedor.getTelefono());
		proveedorModificar.setDireccion(proveedor.getDireccion());
		
		
		proveedoresService.insertarProducto(proveedorModificar);
		
		return "redirect:/proveedores";
	}
}
