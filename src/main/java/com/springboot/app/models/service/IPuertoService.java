package com.springboot.app.models.service;

import java.util.List;

import com.springboot.app.models.entity.Puerto;

public interface IPuertoService {

	public List<Puerto> finAll();
	
	public void save(Puerto puerto);
	
	public Puerto findOne(Long id);
	
	public void delete(Long id);
	
	
}
