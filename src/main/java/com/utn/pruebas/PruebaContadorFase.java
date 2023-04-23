package com.utn.pruebas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.utn.auxiliar.Calculadora;
import com.utn.controller.PartidoController;
import com.utn.modelo.Partido;

public class PruebaContadorFase {
	public static void main(String[] args) {
		PartidoController partidoController = new PartidoController();
		List<Partido> listadoPartidos = partidoController.listar();
		
		Map<Integer, Integer> aciertosRondas= new HashMap<>();
		aciertosRondas.put(1, 0);
		for (Map.Entry<Integer, Integer> entry : aciertosRondas.entrySet()) {
		    Integer key = entry.getKey();
		    Integer value = entry.getValue();
		    System.out.println("Par de valores: " + key + " - " + value);
		}
		
		System.out.println("----------------------------------");		
		
		Calculadora calculadora = new Calculadora();
		Map<Integer, Integer> mapFases= calculadora.calculadoraPartidosPorFase(listadoPartidos);
		System.out.println(mapFases);
		for (Map.Entry<Integer, Integer> entry : mapFases.entrySet()) {
		    Integer key = entry.getKey();
		    Integer value = entry.getValue();
		    System.out.println("Par de valores: " + key + " - " + value);
		}
		
		System.out.println("----------------------------------");
		Map<Integer, Integer> mapRonda = calculadora.calculadoraPartidosPorRonda(listadoPartidos);
		
		for (Map.Entry<Integer, Integer> entry : mapRonda.entrySet()) {
		    Integer key = entry.getKey();
		    Integer value = entry.getValue();
		    System.out.println("Par de valores: " + key + " - " + value);
		}
	}
}
