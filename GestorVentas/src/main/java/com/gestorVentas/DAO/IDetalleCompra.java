package com.gestorVentas.DAO;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gestorVentas.Entidades.*;

@Repository
public interface IDetalleCompra extends JpaRepository<DetalleCompra, Integer>{
	@Query(value="SELECT * FROM detalle_compra where fecha_compra BETWEEN :desde AND :hasta ",nativeQuery = true)
	public List<DetalleCompra> findByRangeDate(@Param("desde") Date desde,@Param("hasta") Date hasta );
	
	@Query(value="SELECT * FROM detalle_compra ORDER BY fecha_compra DESC LIMIT 5",nativeQuery = true)
	public List<DetalleCompra> findAllLimitFive();
	
	public List<DetalleCompra> findByProductos(Producto Producto);
}
