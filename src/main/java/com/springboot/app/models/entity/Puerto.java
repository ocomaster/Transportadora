package com.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "puerto")
public class Puerto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPuerto;
	
	@NotEmpty(message = "El nombre del puerto es obligatorio")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "id_tipoentrega")
	private TipoEntrega tipoEntrega;
	
	

	public Puerto(Long idPuerto, @NotEmpty(message = "El nombre del puerto es obligatorio") String nombre,
			TipoEntrega tipoEntrega) {
		super();
		this.idPuerto = idPuerto;
		this.nombre = nombre;
		this.tipoEntrega = tipoEntrega;
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


	public TipoEntrega getTipoEntrega() {
		return tipoEntrega;
	}


	public void setTipoEntrega(TipoEntrega tipoEntrega) {
		this.tipoEntrega = tipoEntrega;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getIdPuerto() {
		return idPuerto;
	}

	public void setIdPuerto(Long idPuerto) {
		this.idPuerto = idPuerto;
	}



	
	
	
	
	
}
