package com.gestorVentas.Entidades;

import java.sql.Date;

import javax.persistence.*;

import javax.validation.constraints.*;

import org.springframework.lang.NonNull;

@Entity
@Table(name="compras")
public class Compra {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_Compra")
	private int idCompra;
	
	@Column(name="cantidad_producto")
	@NotNull(message = "Debes especificar la cantidad")
	private int cantidad;
	
	
	/*@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_materia_prima", nullable = false)
	@NotNull(message="Debes seleccionar el nombre del producto")
	private MateriaPrima  materiaPrima;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_proveedor", nullable = false)
	@NotNull(message="Debes seleccionar el nombre del producto")
	private Proveedor proveedor;*/
	
	
	
	@Column(name="importe_compra")
	@NotNull(message="Debes especificar el importe de la compra")
	private double importeCompra;

	@Column(name="fecha_compra")
	@NotNull(message="Debes seleccionar la fecha de compra")
	private Date fechaCompra;
	
	
	@OneToOne
	@JoinColumn(name = "id_detalle_compra")
	private DetalleCompra detalleCompra;

	
	
	public DetalleCompra getDetalleCompra() {
		return detalleCompra;
	}



	public void setDetalleCompra(DetalleCompra detalleCompra) {
		this.detalleCompra = detalleCompra;
	}



	public Compra(int idCompra, @NotNull(message = "Debes especificar la cantidad") int cantidad,
			@NotNull(message = "Debes especificar el importe de la compra") double importeCompra,
			@NotNull(message = "Debes seleccionar la fecha de compra") Date fechaCompra, DetalleCompra detalleCompra) {
		super();
		this.idCompra = idCompra;
		this.cantidad = cantidad;
		this.importeCompra = importeCompra;
		this.fechaCompra = fechaCompra;
		this.detalleCompra = detalleCompra;
	}



	/*public Compra(int cantidad, MateriaPrima materiaPrima, Proveedor proveedor, double importeCompra,
			Date fechaCompra) {
		super();
		this.cantidad = cantidad;
		this.materiaPrima = materiaPrima;
		this.proveedor = proveedor;
		this.importeCompra = importeCompra;
		this.fechaCompra = fechaCompra;
	}*/



	public Compra(@NotNull(message = "Debes especificar la cantidad") int cantidad,
			@NotNull(message = "Debes especificar el importe de la compra") double importeCompra,
			@NotNull(message = "Debes seleccionar la fecha de compra") Date fechaCompra, DetalleCompra detalleCompra) {
		super();
		this.cantidad = cantidad;
		this.importeCompra = importeCompra;
		this.fechaCompra = fechaCompra;
		this.detalleCompra = detalleCompra;
	}



	public Date getFechaCompra() {
		return fechaCompra;
	}



	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}



	public int getIdCompra() {
		return idCompra;
	}



	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}



	public int getCantidad() {
		return cantidad;
	}



	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}



	/*public MateriaPrima getMateriaPrima() {
		return materiaPrima;
	}



	public void setMateriaPrima(MateriaPrima materiaPrima) {
		this.materiaPrima = materiaPrima;
	}



	public Proveedor getProveedor() {
		return proveedor;
	}



	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
*/


	public double getImporteCompra() {
		return importeCompra;
	}



	public void setImporteCompra(double importeCompra) {
		this.importeCompra = importeCompra;
	}



	

	/*public Compra(int idCompra, int cantidad, MateriaPrima materiaPrima, Proveedor proveedor, double importeCompra) {
		super();
		this.idCompra = idCompra;
		this.cantidad = cantidad;
		this.materiaPrima = materiaPrima;
		this.proveedor = proveedor;
		this.importeCompra = importeCompra;
	}*/



	public Compra() {
		super();
	}
	
	
	

}
