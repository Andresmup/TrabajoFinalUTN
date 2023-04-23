package com.utn.pruebas;

import java.util.List;

import com.utn.controller.ApostadorController;
import com.utn.modelo.Apostador;

public class PuebaApostador {
	public static void main(String[] args) {
		ApostadorController ac = new ApostadorController();
		List<Apostador> listado = ac.listar();
		for (Apostador apostador : listado) {

			System.out.println(apostador.getId() + ": " + apostador.getPuntos());
			/*
			 * int filasModificadas = pc.modificarPuntajeApostadorPorId(1, 2);
			 * System.out.println(filasModificadas +" filas se modificaron");
			 */
			

		}
	}
}
