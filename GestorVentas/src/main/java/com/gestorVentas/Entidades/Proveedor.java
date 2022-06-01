package com.gestorVentas.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name="proveedores")
public class Proveedor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_Proveedor")
	private int idProveedor;
	
	@Column(name="nombre_proveedor")
	@NonNull
	private String nombreProveedor;
	
	@Column(name="direccion")
	@NonNull
	private String direccion;
	
	@Column(name="telefono")
	@NonNull
	private String telefono;
	
	@Column(name="correo")
	@NonNull
	private String correo;


	
	public int getIdProveedor() {
		return idProveedor;
	}


	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}





	public String getNombreProveedor() {
		return nombreProveedor;
	}





	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}





	public String getDireccion() {
		return direccion;
	}





	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}





	public String getTelefono() {
		return telefono;
	}





	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}





	public String getCorreo() {
		return correo;
	}





	public void setCorreo(String correo) {
		this.correo = correo;
	}





	public Proveedor() {
		super();
	}





	public Proveedor(String nombreProveedor, String direccion, String telefono, String correo) {
		super();
		this.nombreProveedor = nombreProveedor;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
	}


	public Proveedor(int idProveedor, String nombreProveedor, String direccion, String telefono, String correo) {
		super();
		this.idProveedor = idProveedor;
		this.nombreProveedor = nombreProveedor;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
	}
	
	
	
	
	
}
