package com.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "entrega")
public class Entrega implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	
	@ManyToOne
	@JoinColumn(name = "idtipo_producto")
	private TipoProducto tipoProducto;
	
	@ManyToOne
	@JoinColumn(name = "id_vehiculo")
	private Vehiculo vehiculo;
	
	@ManyToOne
	@JoinColumn(name = "id_puerto")
	private Puerto puerto;
	
	
	private Integer cantidad;
	
	private Integer precioEnvio;
	
	@NotNull
	@Column(name = "fecha_registro")
	@Temporal(TemporalType.DATE) // indicacion de formato en la fecha a guardar
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaRegistro;
	
	
	
	
	@PrePersist //de forma automatica se llama en metodo antes de insertar el registro en bd
	public void prePersist() {
		fechaRegistro = new Date();
	}
	
	private Date fechaEntrega;
	
	private Integer precioTotal;
	
	private String guia;




	public Entrega(long id, Cliente cliente, TipoProducto tipoProducto, Vehiculo vehiculo, Puerto puerto,
			Integer cantidad, Integer precioEnvio, @NotNull Date fechaRegistro, Date fechaEntrega, Integer precioTotal,
			String guia) {
		this.id = id;
		this.cliente = cliente;
		this.tipoProducto = tipoProducto;
		this.vehiculo = vehiculo;
		this.puerto = puerto;
		this.cantidad = cantidad;
		this.precioEnvio = precioEnvio;
		this.fechaRegistro = fechaRegistro;
		this.fechaEntrega = fechaEntrega;
		this.precioTotal = precioTotal;
		this.guia = guia;
	}




	public Entrega() {
	}




	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public Cliente getCliente() {
		return cliente;
	}




	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}




	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}




	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}




	public Vehiculo getVehiculo() {
		return vehiculo;
	}




	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}




	public Puerto getPuerto() {
		return puerto;
	}




	public void setPuerto(Puerto puerto) {
		this.puerto = puerto;
	}




	public Integer getCantidad() {
		return cantidad;
	}




	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}




	public Integer getPrecioEnvio() {
		return precioEnvio;
	}




	public void setPrecioEnvio(Integer precioEnvio) {
		this.precioEnvio = precioEnvio;
	}




	public Date getFechaRegistro() {
		return fechaRegistro;
	}




	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}




	public Date getFechaEntrega() {
		return fechaEntrega;
	}




	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}




	public Integer getPrecioTotal() {
		return precioTotal;
	}




	public void setPrecioTotal(Integer precioTotal) {
		this.precioTotal = precioTotal;
	}




	public String getGuia() {
		return guia;
	}




	public void setGuia(String guia) {
		this.guia = guia;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}