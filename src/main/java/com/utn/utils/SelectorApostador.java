package com.utn.utils;

import java.util.List;

import com.utn.controller.ApostadorController;
import com.utn.modelo.Apostador;

public class SelectorApostador {

	private List<Apostador> listadoApostadores;

	public SelectorApostador() {
		ApostadorController ac = new ApostadorController();
		this.listadoApostadores = ac.listar();
	}

	public Apostador recuperarApostador(int id) {
		for (Apostador apostador : listadoApostadores) {
			if (apostador.getId() == id) {
				return apostador;
			}

		}
		return null;
	}

}
