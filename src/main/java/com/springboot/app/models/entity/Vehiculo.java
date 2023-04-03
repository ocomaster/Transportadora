package com.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="vehiculo")
public class Vehiculo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVehiculo;
	
	@NotEmpty(message = "Debe digitar nombre del vehiculo")
	private String nombre;
	
	@NotEmpty(message = "Debe digitar la placa del vehiculo")
	@NotNull
	private String placa;

	public Vehiculo(Long id, @NotEmpty(message = "Debe digitar nombre del vehiculo") String nombre,
			@NotEmpty(message = "Debe digitar la placa del vehiculo") @NotNull String placa) {
		this.idVehiculo = id;
		this.nombre = nombre;
		this.placa = placa;
	}

	public Vehiculo() {
	}

	public Long getId() {
		return idVehiculo;
	}

	public void setId(Long id) {
		this.idVehiculo = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	

}
