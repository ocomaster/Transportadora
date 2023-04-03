package com.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.models.dao.IPuertoDao;
import com.springboot.app.models.entity.Puerto;
@Service
public class PuertoServiceImpl implements IPuertoService {

	@Autowired
	public IPuertoDao puertoDao;
	
	
	@Override
	public List<Puerto> finAll() {
		
		return (List<Puerto>) puertoDao.findAll();
	}

	@Override
	public void save(Puerto puerto) {
		puertoDao.save(puerto);
		
	}

	@Override
	public Puerto findOne(Long id) {
	
		return puertoDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		puertoDao.deleteById(id);
		
	}

}
