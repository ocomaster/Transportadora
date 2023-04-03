package com.springboot.app.models.service;

import java.util.List;

import com.springboot.app.models.entity.TipoEntrega;

public interface ITipoEntregaService {
	
	public List<TipoEntrega> findAll();
	
	public void save(TipoEntrega tipoEntrega);
	
	public TipoEntrega findOne(Long id);
	
	public void delete(Long id);

}
