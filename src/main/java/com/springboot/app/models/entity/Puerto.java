package com.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Puerto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPuerto;
	
	@NotEmpty(message = "El nombre del puerto es obligatorio")
	private String nombre;
	
	


	public Puerto(Long id, @NotEmpty(message = "El nombre del puerto es obligatorio") String nombre, String guia) {
		this.idPuerto = id;
		this.nombre = nombre;
		
	}


	public Puerto() {
	}


	public Long getId() {
		return idPuerto;
	}


	public void setId(Long id) {
		this.idPuerto = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
	
	
	
	
	
}
