package com.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.app.models.entity.TipoEntrega;
import com.springboot.app.models.entity.TipoProducto;

public interface ITipoEntregaDao extends CrudRepository<TipoEntrega,Long>{

}
