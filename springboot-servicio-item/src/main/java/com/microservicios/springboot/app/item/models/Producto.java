package com.microservicios.springboot.app.item.models;

import java.util.Date;

public class Producto {
	
	/*
	 * El proposito de esta clase 
	 * es obtener mediante API Rest
	 * la estructura JSON y convertirla
	 * a un objeto Producto.
	 * Con las mismas caracteristicas
	 * que el original pero no es una clase
	 * Entity.
	 * Es un objeto en el cual se van a guardar
	 * los datos del JSON
	 */	
	private Long id;
	private String nombre;
	private Double precio;
	private Date createAt;
	private Integer port;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	
	
	
	
}
