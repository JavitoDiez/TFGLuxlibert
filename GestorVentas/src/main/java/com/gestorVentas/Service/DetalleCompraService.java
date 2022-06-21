package com.gestorVentas.Service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestorVentas.Model.DetalleCompra;
import com.gestorVentas.Model.Producto;
import com.gestorVentas.Model.Proveedor;
import com.gestorVentas.Repository.IDetalleCompra;

@Service
public class DetalleCompraService implements IDetalleCompraService {

	@Autowired
	IDetalleCompra detalleCompraService;
	
	@Override
	public List<DetalleCompra> findAll() {
		// TODO Auto-generated method stub
		return detalleCompraService.findAll();
	}

	@Override
	public List<DetalleCompra> insertar(List<DetalleCompra> detalleCompra) {
		// TODO Auto-generated method stub
		return detalleCompraService.saveAll(detalleCompra);
	}

	@Override
	public void elimina(DetalleCompra detalleCompra) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<DetalleCompra> findById(int idDetalleCompra) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetalleCompra> findByRangeDate(Date desde, Date hasta) {
		// TODO Auto-generated method stub
		return detalleCompraService.findByRangeDate(desde, hasta);
	}

	@Override
	public List<DetalleCompra> findAllLimitFive() {
		// TODO Auto-generated method stub
		return detalleCompraService.findAllLimitFive();
	}
	
	public Double totalGastosCompras() {

		List<DetalleCompra> listadoCompras = detalleCompraService.findAll();

		double totalGastosCompras = 0;
		for (DetalleCompra compra : listadoCompras) {

			totalGastosCompras += compra.getImporteCompra();

		}

		return totalGastosCompras;
	}
	


@Override
public List<DetalleCompra> findByProduct(Producto producto) {
	// TODO Auto-generated method stub
	return detalleCompraService.findByProductos(producto);
}

}
