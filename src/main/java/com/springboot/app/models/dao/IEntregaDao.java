package com.springboot.app.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springboot.app.models.entity.Cliente;
import com.springboot.app.models.entity.Entrega;

public interface IEntregaDao extends CrudRepository<Entrega, Long>{
	
	List<Entrega> findByCliente(Cliente cliente);
	

}
