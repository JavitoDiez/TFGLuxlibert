package com.gestorVentas.Entidades;

import javax.persistence.Column;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="ventas")
public class Venta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idVenta")
	private int idVenta;
	
	@Column(name="importeVenta")
	private double importeVenta;
	
	@Column(name="fechaVenta")
	private Date fechaVenta;
	
	private int cantidadProductoVendido;
	
	@ManyToMany
	@JoinTable(name="detalleventa",joinColumns = @JoinColumn(name="idVenta"),inverseJoinColumns = @JoinColumn(name="idProducto"))
	private List<ProductoEnt> productosVendidos;
	
}
