package com.utn.utils;

import java.util.List;

import com.utn.controller.SeleccionadoController;
import com.utn.modelo.Seleccionado;

public class SelectorSeleccionado {
	private List<Seleccionado> listadoSelecciones;

	public SelectorSeleccionado() {
		SeleccionadoController sc = new SeleccionadoController();
		this.listadoSelecciones = sc.listar();
	}

	public Seleccionado recuperarSeleccion(String id) {
		for (Seleccionado seleccion : listadoSelecciones) {
			if (seleccion.getId().equals(id)) {
				return seleccion;
			}

		}
		return null;
	}

}
