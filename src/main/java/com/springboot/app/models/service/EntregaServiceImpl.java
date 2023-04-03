package com.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.app.models.dao.IClienteDao;
import com.springboot.app.models.dao.IEntregaDao;
import com.springboot.app.models.entity.Cliente;
import com.springboot.app.models.entity.Entrega;

public class EntregaServiceImpl implements IEntregaService {
	
	@Autowired
	public IEntregaDao entregaDao;
	
	@Autowired
	public IClienteDao clienteDao;

	@Override
	public List<Entrega> findAll() {
		
		return (List<Entrega>) entregaDao.findAll();
	}

	@Override
	public void save(Entrega entrega) {
		entregaDao.save(entrega);
		
	}

	@Override
	public Entrega findOne(Long id) {
		
		return entregaDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		entregaDao.deleteById(id);
		
	}

	@Override
	public List<Cliente> clientefindAll() {
		
		return (List<Cliente>) clienteDao.findAll();
	}

}
