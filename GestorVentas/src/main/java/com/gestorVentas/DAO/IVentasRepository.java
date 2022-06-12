package com.gestorVentas.DAO;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gestorVentas.Entidades.Compra;
import com.gestorVentas.Entidades.Venta;

public interface IVentasRepository extends JpaRepository<Venta, Integer>{

	@Query(value="SELECT * FROM ventas where fecha_venta BETWEEN :desde AND :hasta ",nativeQuery = true)
	public List<Venta> findByRangeDate(@Param("desde") Date desde,@Param("hasta") Date hasta );
	
	@Query(value="SELECT SUM(importe_venta),id_venta FROM gestorventas.ventas group by id_producto", nativeQuery = true)
	public List<Venta> ventasPorProductos();
}
