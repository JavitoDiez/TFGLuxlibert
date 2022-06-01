package com.gestorVentas.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name="administradoressistema")
public class AdministradorSistema {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_Administrador_Sistema")
	private int idAdministradorSistema;
	
	
	@Column(name="usuario_administrador")
	@NonNull
	private String usuario;
	
	@Column(name="clave_administrador")
	@NonNull
	private String claveAdministrador;

	public AdministradorSistema(int idAdministradorSistema, String usuario, String claveAdministrador) {
		super();
		this.idAdministradorSistema = idAdministradorSistema;
		this.usuario = usuario;
		this.claveAdministrador = claveAdministrador;
	}

	public AdministradorSistema(String usuario, String claveAdministrador) {
		super();
		this.usuario = usuario;
		this.claveAdministrador = claveAdministrador;
	}

	public int getIdAdministradorSistema() {
		return idAdministradorSistema;
	}

	public void setIdAdministradorSistema(int idAdministradorSistema) {
		this.idAdministradorSistema = idAdministradorSistema;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClaveAdministrador() {
		return claveAdministrador;
	}

	public void setClaveAdministrador(String claveAdministrador) {
		this.claveAdministrador = claveAdministrador;
	}
	
	
	
}
