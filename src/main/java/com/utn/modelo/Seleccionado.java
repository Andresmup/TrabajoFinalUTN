package com.utn.modelo;

public class Seleccionado {
	private String id;
	private String nombre;
	private String descripcion;
	
	
	public Seleccionado(String id, String nombre, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getId() {
		return id;
	}
	
	

}
