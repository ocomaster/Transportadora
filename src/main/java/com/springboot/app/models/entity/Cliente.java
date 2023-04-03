package com.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name ="cliente")
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L; // Indicacion de serializable
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCliente;
	
	
	@NotEmpty(message = "Debe digitar el campo nombre") //Anotacion de indicacion para el campo
	private String nombre;
	
	@NotEmpty(message = "Debe digitar el campo apellido") //Anotacion de indicacion para el campo
	private String apellido;

	@NotEmpty
	@Email
	private String email;
	
	

	public Long getId() {
		return idCliente;
	}

	public void setId(Long id) {
		this.idCliente = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
