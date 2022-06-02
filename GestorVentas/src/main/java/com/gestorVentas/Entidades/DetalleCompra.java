package com.gestorVentas.Entidades;

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
	private ProductoEnt listaProductos;
	
	
	@ManyToOne
	@JoinColumn(name="id_proveedor_pk",nullable=false)
	@NotNull(message = "Selecciona la categoria del producto")
	private Proveedor listaProveedores;
	
	@OneToOne
	@JoinColumn(name="id_compra",nullable=false)
	@NotNull(message = "Selecciona la categoria del producto")
	private Compra compra;

	public int getIdDetalleCompra() {
		return idDetalleCompra;
	}

	public void setIdDetalleCompra(int idDetalleCompra) {
		this.idDetalleCompra = idDetalleCompra;
	}

	public ProductoEnt getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(ProductoEnt listaProductos) {
		this.listaProductos = listaProductos;
	}

	public Proveedor getListaProveedores() {
		return listaProveedores;
	}

	public void setListaProveedores(Proveedor listaProveedores) {
		this.listaProveedores = listaProveedores;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	@Override
	public String toString() {
		return "DetalleCompra [idDetalleCompra=" + idDetalleCompra + ", listaProductos=" + listaProductos
				+ ", listaProveedores=" + listaProveedores + ", compra=" + compra + "]";
	}
	
	
	
	
	
}
