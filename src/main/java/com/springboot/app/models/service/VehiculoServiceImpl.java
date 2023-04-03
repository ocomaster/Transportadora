package com.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.models.dao.ITipoEntregaDao;
import com.springboot.app.models.dao.IVehiculoDao;
import com.springboot.app.models.entity.TipoEntrega;
import com.springboot.app.models.entity.Vehiculo;
@Service
public class VehiculoServiceImpl implements IVehiculoService {
	
	@Autowired
	public IVehiculoDao vehiculoDao;
	
	@Autowired
	public ITipoEntregaDao tipoEntregaDao;

	@Override
	public List<Vehiculo> findAll() {
		return  (List<Vehiculo>) vehiculoDao.findAll();
	}

	@Override
	public void save(Vehiculo vehiculo) {
		vehiculoDao.save(vehiculo);
		
	}

	@Override
	public Vehiculo findOne(Long id) {
	
		return vehiculoDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		vehiculoDao.deleteById(id);
		
	}

	@Override
	public List<TipoEntrega> tipoentregafindAll() {
		
		return (List<TipoEntrega>) tipoEntregaDao.findAll();
	}

}
