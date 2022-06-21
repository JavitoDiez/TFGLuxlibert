package com.gestorVentas.Model;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="ventas")
public class Venta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_venta")
	private int idVenta;
	
	@Column(name="importe_venta")
	private double importeVenta;
	
	@Column(name="fecha_venta")
	private Date fechaVenta;
	
	@Column(name="cantidad_producto_vendido")
	private int cantidadProductoVendido;
	
	
	@ManyToOne
	@JoinColumn(name="id_producto")
	private Producto producto;


	public int getIdVenta() {
		return idVenta;
	}


	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}


	public double getImporteVenta() {
		return importeVenta;
	}


	public void setImporteVenta(double importeVenta) {
		this.importeVenta = importeVenta;
	}


	public Date getFechaVenta() {
		return fechaVenta;
	}


	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}


	public int getCantidadProductoVendido() {
		return cantidadProductoVendido;
	}


	public void setCantidadProductoVendido(int cantidadProductoVendido) {
		this.cantidadProductoVendido = cantidadProductoVendido;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public Venta(double importeVenta, Date fechaVenta, int cantidadProductoVendido, Producto producto) {
		super();
		this.importeVenta = importeVenta;
		this.fechaVenta = fechaVenta;
		this.cantidadProductoVendido = cantidadProductoVendido;
		this.producto = producto;
	}
	
	

	public Venta() {
		super();
	}


	public Venta(int idVenta, double importeVenta, Date fechaVenta, int cantidadProductoVendido, Producto producto) {
		super();
		this.idVenta = idVenta;
		this.importeVenta = importeVenta;
		this.fechaVenta = fechaVenta;
		this.cantidadProductoVendido = cantidadProductoVendido;
		this.producto = producto;
	}


	@Override
	public String toString() {
		return "Venta [idVenta=" + idVenta + ", importeVenta=" + importeVenta + ", fechaVenta=" + fechaVenta
				+ ", cantidadProductoVendido=" + cantidadProductoVendido + ", producto=" + producto + "]";
	}
	
	
	
}
