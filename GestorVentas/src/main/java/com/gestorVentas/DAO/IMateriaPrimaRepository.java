package com.gestorVentas.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gestorVentas.Entidades.CategoriaProducto;
import com.gestorVentas.Entidades.MateriaPrima;
import com.gestorVentas.Entidades.ProductoEnt;

@Repository
public interface IMateriaPrimaRepository extends JpaRepository<MateriaPrima, Integer>{

	@Query(value="SELECT * FROM materiasprimas where nombre = :nombre ",nativeQuery = true)
	public MateriaPrima findByName(@Param("nombre") String nombre);
}
