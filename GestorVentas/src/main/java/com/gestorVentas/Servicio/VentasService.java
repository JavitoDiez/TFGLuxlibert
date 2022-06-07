package com.gestorVentas.Servicio;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gestorVentas.DAO.IVentasRepository;
import com.gestorVentas.Entidades.Venta;

@Service
public class VentasService implements IVentasService {

	@Autowired
	IVentasRepository ventasRepository;
	
	@Override
	public List<Venta> findAll() {
		// TODO Auto-generated method stub
		return ventasRepository.findAll();
	}

	@Override
	public List<Venta> findAllLimitFive() {
		// TODO Auto-generated method stub
		return ventasRepository.findAll();
	}

	@Override
	public Page<Venta> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return ventasRepository.findAll(pageable);
	}

	@Override
	public Venta realizarVenta(Venta venta) {
		// TODO Auto-generated method stub
		return ventasRepository.save(venta);
	}

	@Override
	public List<Venta> findByRangeDate(Date desde, Date hasta) {
		// TODO Auto-generated method stub
		return ventasRepository.findByRangeDate(desde, hasta);
	}

}
