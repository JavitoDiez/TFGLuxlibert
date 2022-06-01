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

	@Query(value="SELECT * FROM compras where fecha_compra BETWEEN :desde AND :hasta ",nativeQuery = true)
	public List<Compra> findByRangeDate(@Param("desde") Date desde,@Param("hasta") Date hasta );
	
	@Query(value="SELECT * FROM compras ORDER BY fecha_compra DESC LIMIT 5",nativeQuery = true)
	public List<Compra> findAllLimitFive();
	
}
