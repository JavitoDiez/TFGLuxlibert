package com.gestorVentas.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;

import org.springframework.stereotype.Service;

import com.gestorVentas.Model.AdministradorSistema;
import com.gestorVentas.Repository.IAdministradorSistema;

@Service
public class AdministradorService implements IAdministrador{

	@Autowired
	IAdministradorSistema administradorRepo;
	
	@Override
	public AdministradorSistema findByUser(String usuario) {
		// TODO Auto-generated method stub
		return administradorRepo.findByUsuario(usuario);
	}

	

}
