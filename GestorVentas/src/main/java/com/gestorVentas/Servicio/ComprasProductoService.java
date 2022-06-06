package com.gestorVentas.Servicio;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gestorVentas.DAO.IComprasProductos;
import com.gestorVentas.Entidades.Compra;

@Service
public class ComprasProductoService implements ICompraProductoService {

	
	@Autowired
	IComprasProductos compraRepository;
	
	
	@Override
	public List<Compra> findAll() {
	
		return compraRepository.findAll();
	}

	@Override
	public Compra realizarCompra(Compra compra) {
		
		
		return compraRepository.save(compra);
	}

	

	@Override
	public Page<Compra> findAll(int pageNumber) {
		Pageable pageable =PageRequest.of(pageNumber -1 ,5);
		return compraRepository.findAll(pageable);
	}



}
