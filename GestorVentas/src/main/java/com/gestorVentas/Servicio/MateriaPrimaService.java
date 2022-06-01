package com.gestorVentas.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestorVentas.DAO.IMateriaPrimaRepository;
import com.gestorVentas.Entidades.MateriaPrima;
import com.gestorVentas.Entidades.ProductoEnt;

@Service
public class MateriaPrimaService  implements IMateriaPrimaService{

	@Autowired
	IMateriaPrimaRepository materiaPrimaRepository;
	
	@Override
	public List<MateriaPrima> findAll() {
		// TODO Auto-generated method stub
		return materiaPrimaRepository.findAll();
	}

	@Override
	public MateriaPrima insertarMateriaPrima(MateriaPrima materiaPrima) {
		// TODO Auto-generated method stub
		return materiaPrimaRepository.save(materiaPrima);
	}

	@Override
	public void eliminarMateriaPrima(MateriaPrima materiaPrima) {
		
		
		materiaPrimaRepository.delete(materiaPrima);
	}

	@Override
	public Optional<MateriaPrima> findById(int idMateriaPrima) {
		// TODO Auto-generated method stub
		return materiaPrimaRepository.findById(idMateriaPrima);
	}

	@Override
	public MateriaPrima findByName(String nombre) {
		// TODO Auto-generated method stub
		return materiaPrimaRepository.findByName(nombre);
	}

	

}
