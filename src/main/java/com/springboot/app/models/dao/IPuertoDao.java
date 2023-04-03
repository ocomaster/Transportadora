package com.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.app.models.entity.Puerto;

public interface IPuertoDao extends CrudRepository<Puerto, Long> {

}
