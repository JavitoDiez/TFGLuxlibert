package com.gestorVentas.Entidades;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="detalleVenta")
public class DetalleVenta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idDetalleVenta")
	private int idDetalleVenta;
	
	@ManyToOne
	@JoinColumn(name="idProducto")
	private ProductoEnt producto;
	
	@ManyToOne
	@JoinColumn(name="idVenta")
	private Venta venta;

	
	public int getIdDetalleVenta() {
		return idDetalleVenta;
	}

	public void setIdDetalleVenta(int idDetalleVenta) {
		this.idDetalleVenta = idDetalleVenta;
	}

	public ProductoEnt getProducto() {
		return producto;
	}

	public void setProducto(ProductoEnt producto) {
		this.producto = producto;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public DetalleVenta(int idDetalleVenta, ProductoEnt producto, Venta venta) {
		super();
		this.idDetalleVenta = idDetalleVenta;
		this.producto = producto;
		this.venta = venta;
	}

	public DetalleVenta(ProductoEnt producto, Venta venta) {
		super();
		this.producto = producto;
		this.venta = venta;
	}

	public DetalleVenta() {
		super();
	}
	
	

}
