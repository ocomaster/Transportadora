package com.springboot.app.models.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "tipoproducto")
public class TipoProducto {
	
	private static final long serialVersionUID = 1L; // Indicacion de serializable
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTipoProducto;
	
	
	private String nombre;


	public Long getId() {
		return idTipoProducto;
	}


	public void setId(Long id) {
		this.idTipoProducto = id;
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
