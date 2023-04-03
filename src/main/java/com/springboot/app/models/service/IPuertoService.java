package com.springboot.app.models.service;

import java.util.List;

import com.springboot.app.models.entity.Puerto;
import com.springboot.app.models.entity.TipoEntrega;

public interface IPuertoService {

	public List<Puerto> findAll();
	
	public List<TipoEntrega> tipoentregafindAll();
	
	public void save(Puerto puerto);
	
	public Puerto findOne(Long id);
	
	public void delete(Long id);
	
	
}
