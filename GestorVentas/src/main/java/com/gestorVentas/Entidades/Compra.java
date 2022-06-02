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

	
	
	
	@OneToOne
	@JoinColumn(name = "id_detalle_compra_pk")
	private DetalleCompra detalleCompra;

	
	


	public int getIdCompra() {
		return idCompra;
	}





	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}





	public double getImporteCompra() {
		return importeCompra;
	}





	public void setImporteCompra(double importeCompra) {
		this.importeCompra = importeCompra;
	}





	public DetalleCompra getDetalleCompra() {
		return detalleCompra;
	}





	public void setDetalleCompra(DetalleCompra detalleCompra) {
		this.detalleCompra = detalleCompra;
	}





	public Compra(@NotNull(message = "Debes especificar el importe de la compra") double importeCompra,
			DetalleCompra detalleCompra) {
		super();
		this.importeCompra = importeCompra;
		this.detalleCompra = detalleCompra;
	}





	public Compra(int idCompra, @NotNull(message = "Debes especificar el importe de la compra") double importeCompra,
			DetalleCompra detalleCompra) {
		super();
		this.idCompra = idCompra;
		this.importeCompra = importeCompra;
		this.detalleCompra = detalleCompra;
	}





	public Compra() {
		super();
	}
	
	
	

}
