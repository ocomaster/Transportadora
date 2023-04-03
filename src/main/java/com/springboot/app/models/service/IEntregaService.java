package com.springboot.app.models.service;

import java.util.List;

import com.springboot.app.models.entity.Cliente;
import com.springboot.app.models.entity.Entrega;

public interface IEntregaService {

	
	public List<Entrega> findAll();
	
	public List<Cliente> clientefindAll();
	
	public void save(Entrega entrega);
	
	public Entrega findOne(Long id);
	
	public void delete(Long id);
	
}
