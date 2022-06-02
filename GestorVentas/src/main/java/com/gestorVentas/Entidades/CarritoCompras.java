package com.gestorVentas.Entidades;

import java.util.Date;

public class CarritoCompras {

	
	private ProductoEnt productoEnt;
	
	private int Cantidad;
	
	private Proveedor proveedor;
	
	private Date fecha;
	
	private double importe;

	public ProductoEnt getProductoEnt() {
		return productoEnt;
	}

	public void setProductoEnt(ProductoEnt productoEnt) {
		this.productoEnt = productoEnt;
	}

	public int getCantidad() {
		return Cantidad;
	}

	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public CarritoCompras(ProductoEnt productoEnt, int cantidad, Proveedor proveedor, Date fecha, double importe) {
		super();
		this.productoEnt = productoEnt;
		Cantidad = cantidad;
		this.proveedor = proveedor;
		this.fecha = fecha;
		this.importe = importe;
	}

	public CarritoCompras() {
		super();
	}
	
	
	
	
}
