package com.gestorVentas.Model;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name="productos_acabados")
public class Producto {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_producto")
	private int idProducto;
	
	@Column(name="nombre_producto",nullable=false)
	@Size(min = 1, max = 45, message = "El nombre debe medir entre 1 y 45")
	private String nombreProducto;
	
	@Column(name="descripcion",nullable=true)
	@Size(min = 1, max = 45, message = "El nombre debe medir entre 1 y 45")
	private String descripcion;
	
	@OneToOne
	@JoinColumn(name="id_categoria_producto",nullable=false)
	@NotNull(message = "Selecciona la categoria del producto")
	private CategoriaProducto categoriaProducto; 	
	
	@Column(name="precio_venta",nullable=false)
	@NotNull(message = "Debes especificar el precio de venta")
	@Min(value = 0, message = "El precio mínimo es 0")
	private double precioVenta;
	
	@Column(name="precio_compra")
	private double precioCompra;
	
	@Column(name="stock",nullable=true)
	private int stock;

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	

	public double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public CategoriaProducto getcategoriaProducto() {
		return categoriaProducto;
	}

	public void setIdCategoriaProducto(CategoriaProducto idCategoriaProducto) {
		this.categoriaProducto = idCategoriaProducto;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Producto() {
		super();
	}

	public Producto(int idProducto, String nombreProducto, String descripcion, CategoriaProducto categoriaProducto,
			double precioVenta, int stock) {
		super();
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.descripcion = descripcion;
		this.categoriaProducto = categoriaProducto;
		this.precioVenta = precioVenta;
		this.stock = stock;
	}
	
	

	public Producto(String nombreProducto, String descripcion, CategoriaProducto categoriaProducto,
			double precioVenta, double precioCompra) {
		super();
		this.nombreProducto = nombreProducto;
		this.descripcion = descripcion;
		this.categoriaProducto = categoriaProducto;
		this.precioVenta = precioVenta;
		this.precioCompra = precioCompra;
	}

	public Producto(String nombreProducto, String descripcion, CategoriaProducto categoriaProducto,
			double precioVenta, int stock) {
		super();
		this.nombreProducto = nombreProducto;
		this.descripcion = descripcion;
		this.categoriaProducto = categoriaProducto;
		this.precioVenta = precioVenta;
		this.stock = stock;
	}

	
	@Override
	public String toString() {
		return "ProductoEnt [idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", descripcion="
				+ descripcion + ", idCategoriaProducto=" + categoriaProducto + ", precioVenta=" + precioVenta
				+ ", stock=" + stock + "]";
	}

	public CategoriaProducto getCategoriaProducto() {
		return categoriaProducto;
	}

	public void setCategoriaProducto(CategoriaProducto categoriaProducto) {
		this.categoriaProducto = categoriaProducto;
	}
	
	
	
}
