package com.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.models.dao.ITipoEntregaDao;
import com.springboot.app.models.entity.TipoEntrega;

@Service
public class TipoEntregaServiceImpl implements ITipoEntregaService{

	@Autowired
	public ITipoEntregaDao tipoEntregaDao;
	
	@Override
	@org.springframework.transaction.annotation.Transactional(readOnly = true)  //Anotacion metodo de lectura
	public List<TipoEntrega> findAll() {
		
		return (List<TipoEntrega>) tipoEntregaDao.findAll();
	}

	@Override
	public void save(TipoEntrega tipoEntrega) {
		tipoEntregaDao.save(tipoEntrega);
		
	}

	@Override
	public TipoEntrega findOne(Long id) {
		
		return tipoEntregaDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		tipoEntregaDao.deleteById(id);
		
	}

}
