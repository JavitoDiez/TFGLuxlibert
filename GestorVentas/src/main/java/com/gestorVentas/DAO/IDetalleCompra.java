package com.gestorVentas.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestorVentas.Entidades.*;

@Repository
public interface IDetalleCompra extends JpaRepository<DetalleCompra, Integer>{

}
