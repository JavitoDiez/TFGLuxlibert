package com.gestorVentas.DAO;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gestorVentas.Entidades.CategoriaProducto;
import com.gestorVentas.Entidades.Compra;

@Repository
public interface IComprasProductos extends JpaRepository<Compra, Integer>{

	
	
}
