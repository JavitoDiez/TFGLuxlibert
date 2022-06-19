package com.gestorVentas.Entidades;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="detalle_compra")
public class DetalleCompra {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_detalle_compra")
	private int idDetalleCompra;
	


	@ManyToOne
	@JoinColumn(name="id_producto_pk",nullable=false)
	@NotNull(message = "Selecciona la categoria del producto")
	private Producto productos;
	
	
	@ManyToOne
	@JoinColumn(name="id_proveedor_pk",nullable=false)
	@NotNull(message = "Selecciona la categoria del producto")
	private Proveedor proveedores;
	
	@Column(name="fecha_compra")
	@NotNull(message="Debes seleccionar la fecha de compra")
	private Date fechaCompra;
	
	@Column(name="importe_compra")
	@NotNull(message="Debes especificar el importe de la compra")
	private double importeCompra;

	
	@Column(name="cantidad_producto")
	@NotNull(message = "Debes especificar la cantidad")
	private int cantidad;
	
	/*@OneToOne
	@JoinColumn(name="id_compra",nullable=false)
	@NotNull(message = "Selecciona la categoria del producto")
	private Compra compra;*/

	public int getIdDetalleCompra() {
		return idDetalleCompra;
	}

	public void setIdDetalleCompra(int idDetalleCompra) {
		this.idDetalleCompra = idDetalleCompra;
	}

	public Producto getProductos() {
		return productos;
	}

	public void setProductos(Producto listaProductos) {
		this.productos = listaProductos;
	}

	public Proveedor getProveedores() {
		return proveedores;
	}

	public void setProveedores(Proveedor listaProveedores) {
		this.proveedores = listaProveedores;
	}

	
	
	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(java.util.Date date) {
		this.fechaCompra = date;
	}

	public double getImporteCompra() {
		return importeCompra;
	}

	public void setImporteCompra(double importeCompra) {
		this.importeCompra = importeCompra;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	/*public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}*/

	@Override
	public String toString() {
		return "DetalleCompra [idDetalleCompra=" + idDetalleCompra + ", listaProductos=" + productos
				+ ", listaProveedores=" + proveedores+"]";
	}
	
	
	
	
	
}
