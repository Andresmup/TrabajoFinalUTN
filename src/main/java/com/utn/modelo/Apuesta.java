package com.utn.modelo;

public class Apuesta {
	private int id;
	private Apostador apostador;
	private Partido partido;
	private String resultadoEsperado;
	
		
	public Apuesta(int id, Apostador apostador, Partido partido, String resultadoEsperado) {
		this.id = id;
		this.apostador = apostador;
		this.partido = partido;
		this.resultadoEsperado = resultadoEsperado;
	}
	public int getId() {
		return id;
	}
	public Apostador getApostador() {
		return apostador;
	}
	public Partido getPartido() {
		return partido;
	}
	public String getResultadoEsperado() {
		return resultadoEsperado;
	}
	
	
	
	
}
