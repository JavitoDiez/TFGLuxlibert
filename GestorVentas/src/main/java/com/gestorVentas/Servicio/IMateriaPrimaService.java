package com.gestorVentas.Servicio;

import java.util.List;
import java.util.Optional;

import com.gestorVentas.Entidades.MateriaPrima;
import com.gestorVentas.Entidades.ProductoEnt;

public interface IMateriaPrimaService {

	
	public List<MateriaPrima> findAll();
	
	public MateriaPrima insertarMateriaPrima(MateriaPrima materiaPrima);
	
	public void eliminarMateriaPrima(MateriaPrima materiaPrima);
	
	public Optional<MateriaPrima> findById(int idMateriaPrima);
	
	public MateriaPrima findByName(String nombre);
	

	
	
	
	
	
	
	
}
