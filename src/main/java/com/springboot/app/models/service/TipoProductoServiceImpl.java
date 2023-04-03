package com.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.models.dao.ITipoProductoDao;
import com.springboot.app.models.entity.TipoProducto;

@Service
public class TipoProductoServiceImpl  implements ITipoProductoService{
	
	@Autowired
	public ITipoProductoDao tipoProductoDao;

	@Override
	@org.springframework.transaction.annotation.Transactional(readOnly = true)  //Anotacion metodo de lectura
	public List<TipoProducto> findAll() {
		
		return (List<TipoProducto>) tipoProductoDao.findAll();
	}

	@Override
	public void save(TipoProducto tipoProducto) {
		 tipoProductoDao.save(tipoProducto);
		
	}

	@Override
	public TipoProducto findOne(Long id) {
		
		return tipoProductoDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		tipoProductoDao.deleteById(id);
		
	}

}
