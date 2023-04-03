package com.springboot.app.models.service;

import java.util.List;

import com.springboot.app.models.entity.TipoProducto;

public interface ITipoProductoService {
	
	public List<TipoProducto> findAll();
	
	public void save(TipoProducto tipoProducto);
	
	public TipoProducto findOne(Long id);
	
	public void delete(Long id);

}
