package com.gestorVentas.Entidades;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="ventas")
public class Venta {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_venta")
	private int idVenta;
	
	@Column(name="importe_venta")
	private double importeVenta;
	
	@Column(name="fecha_venta")
	private Date fechaVenta;
	
	@Column(name="cantidad_producto_vendido")
	private int cantidadProductoVendido;
	
	
	@OneToMany
	@JoinColumn(name="id_producto" ,table = "productos_acabados")
	private ProductoEnt producto;


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


	public ProductoEnt getProducto() {
		return producto;
	}


	public void setProducto(ProductoEnt producto) {
		this.producto = producto;
	}


	public Venta(double importeVenta, Date fechaVenta, int cantidadProductoVendido, ProductoEnt producto) {
		super();
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
