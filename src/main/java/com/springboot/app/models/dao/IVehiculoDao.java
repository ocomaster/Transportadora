package com.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.app.models.entity.Vehiculo;

public interface IVehiculoDao extends CrudRepository<Vehiculo, Long> {

}
