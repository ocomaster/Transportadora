package com.springboot.app.models.service;

import java.util.List;

import com.springboot.app.models.entity.Vehiculo;

public interface IVehiculoService {

	public List<Vehiculo> findAll();
	
	public void save(Vehiculo vehiculo);
	
	public Vehiculo findOne(Long id);
	
	public void delete(Long id);
	
	
}
