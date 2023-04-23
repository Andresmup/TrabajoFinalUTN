package com.utn.utils;

import java.util.List;

import com.utn.controller.PartidoController;
import com.utn.modelo.Partido;

public class SelectorPartido {

	private List<Partido> listadoPartidos;

	public SelectorPartido() {
		PartidoController pc = new PartidoController();
		this.listadoPartidos = pc.listar();
	}

	public Partido recuperarPartido(int id) {
		for (Partido partido : listadoPartidos) {
			if (partido.getId() == id) {
				return partido;
			}

		}
		return null;
	}

}
