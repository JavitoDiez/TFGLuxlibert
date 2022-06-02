package com.gestorVentas.Entidades;

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
	
	
	
	/*@ManyToMany
	@JoinTable(name="detalleventa",joinColumns = @JoinColumn(name="idVenta"),inverseJoinColumns = @JoinColumn(name="idProducto"))
	private List<ProductoEnt> productosVendidos;*/
	
	@OneToOne
	@JoinColumn(name="idDetalleVenta")
	private DetalleVenta detalleVenta;
}
