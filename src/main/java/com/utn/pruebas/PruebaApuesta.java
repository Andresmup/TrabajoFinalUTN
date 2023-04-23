package com.utn.pruebas;

import java.util.List;

import com.utn.controller.ApuestaController;
import com.utn.modelo.Apuesta;


public class PruebaApuesta {
	public static void main(String[] args) {
		ApuestaController ac = new ApuestaController();
		List<Apuesta> listado = ac.listar();
		
		System.out.println("Nombre Apostador" + " | " + "Ganador" + " | " + "Resultado Esperado");
		for(Apuesta apuesta: listado) {
			System.out.println(apuesta.getApostador().getNombre() + " | " + apuesta.getPartido().getGanador() + " | " + apuesta.getResultadoEsperado());
		}
	}
}
