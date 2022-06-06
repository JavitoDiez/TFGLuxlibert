package com.gestorVentas.Servicio;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestorVentas.DAO.IDetalleCompra;
import com.gestorVentas.Entidades.DetalleCompra;

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

}
