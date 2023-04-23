package com.utn.pruebas;

import java.util.List;

import com.utn.controller.PartidoController;
import com.utn.modelo.Partido;

public class PruebaPartido {
	public static void main(String[] args) {
		
		PartidoController pc = new PartidoController();
		List<Partido> listado = pc.listar();
		
		for(Partido partido: listado) {
			System.out.println(partido.getEquipoUno().getId() + ": " +partido.getGolesEquipoUno() + " vs " + partido.getEquipoDos().getId()+ ": " +partido.getGolesEquipoDos());
		}
		
		
	}
}
