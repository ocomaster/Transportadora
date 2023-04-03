package com.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.models.dao.IPuertoDao;
import com.springboot.app.models.dao.ITipoEntregaDao;
import com.springboot.app.models.entity.Puerto;
import com.springboot.app.models.entity.TipoEntrega;
@Service
public class PuertoServiceImpl implements IPuertoService {

	@Autowired
	public IPuertoDao puertoDao;
	
	@Autowired
	public ITipoEntregaDao tipoEntregaDao;
	
	
	@Override
	public List<Puerto> findAll() {
		
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

	@Override
	public List<TipoEntrega> tipoentregafindAll() {
		
		return (List<TipoEntrega>) tipoEntregaDao.findAll();
	}

	

}
