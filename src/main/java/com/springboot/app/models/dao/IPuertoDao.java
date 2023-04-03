package com.springboot.app.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springboot.app.models.entity.Puerto;
import com.springboot.app.models.entity.TipoEntrega;

public interface IPuertoDao extends CrudRepository<Puerto, Long> {

	List<TipoEntrega> findByTipoEntrega(TipoEntrega tipoEntrega);
}
