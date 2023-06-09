package com.springboot.app.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springboot.app.models.entity.TipoEntrega;
import com.springboot.app.models.entity.Vehiculo;

public interface IVehiculoDao extends CrudRepository<Vehiculo, Long> {

	List<TipoEntrega> findByTipoEntrega(TipoEntrega tipoEntrega);
}
