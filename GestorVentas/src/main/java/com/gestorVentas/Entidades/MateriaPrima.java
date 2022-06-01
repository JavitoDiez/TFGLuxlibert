package com.gestorVentas.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.lang.NonNull;

@Entity
@Table(name="materiasprimas")
public class MateriaPrima {

	public MateriaPrima() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idmateria_prima")
	int idMateriaPrima;
	
	
	@Column(name="nombre")
	@NonNull
	String nombre;
	
	@Column(name="stock")
	int stock;

	public int getIdMateriaPrima() {
		return idMateriaPrima;
	}

	public void setIdMateriaPrima(int idMateriaPrima) {
		this.idMateriaPrima = idMateriaPrima;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	

	public MateriaPrima(String nombre, int stock) {
		super();
		this.nombre = nombre;
		this.stock = stock;
	}

	public MateriaPrima(int idMateriaPrima, String nombre, int stock) {
		super();
		this.idMateriaPrima = idMateriaPrima;
		this.nombre = nombre;
		this.stock = stock;
	}

	public MateriaPrima(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	
	
	
}
