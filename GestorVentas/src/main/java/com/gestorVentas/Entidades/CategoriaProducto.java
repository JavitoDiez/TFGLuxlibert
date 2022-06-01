package com.gestorVentas.Entidades;

import javax.persistence.*;


@Entity
@Table(name="categoriaproducto")
public class CategoriaProducto {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_categoria_producto")
	private int idCategoriaProducto;
	
	@Column(name = "categoria")
	private String categoria;

	public int getIdCategoria() {
		return idCategoriaProducto;
	}

	public void setIdCategoria(int idCategoriaProducto) {
		this.idCategoriaProducto = idCategoriaProducto;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public CategoriaProducto(int idCategoria, String categoria) {
		super();
		this.idCategoriaProducto = idCategoria;
		this.categoria = categoria;
	}

	
	@Override
	public String toString() {
		return "CategoriaProducto [idCategoria=" + idCategoriaProducto + ", categoria=" + categoria + "]";
	}

	
	public CategoriaProducto() {
		super();
	}

	public CategoriaProducto(String categoria) {
		super();
		this.categoria = categoria;
	}
	
	
	
	
	
	
	

}
