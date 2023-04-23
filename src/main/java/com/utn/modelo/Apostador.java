package com.utn.modelo;

import java.util.HashMap;
import java.util.Map;

public class Apostador {
	private Integer id;
	private String nombre;
	private String apellido;
	private Integer puntos;

	private Map<Integer, Integer> mapPartidosAcertadosFases = new HashMap<>();
	private Map<Integer, Integer> mapPartidosAcertadosRondas = new HashMap<>();

	public Apostador(Integer id, String nombre, String apellido, Integer puntos) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.puntos = puntos;
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

	public Integer getPuntos() {
		return puntos;
	}

	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}

	public void sumarUnPunto() {
		this.puntos = +1;
	}

	public Integer getId() {
		return id;
	}

	public Map<Integer, Integer> getMapPartidosAcertadosFases() {
		return mapPartidosAcertadosFases;
	}

	public void setMapPartidosAcertadosFases(Map<Integer, Integer> mapPartidosAcertadosFases) {
		this.mapPartidosAcertadosFases = mapPartidosAcertadosFases;
	}

	public Map<Integer, Integer> getMapPartidosAcertadosRondas() {
		return mapPartidosAcertadosRondas;
	}

	public void setMapPartidosAcertadosRondas(Map<Integer, Integer> mapPartidosAcertadosRondas) {
		this.mapPartidosAcertadosRondas = mapPartidosAcertadosRondas;
	}

}
