package com.utn;

import java.util.List;
import java.util.Map;

import com.utn.auxiliar.Calculadora;
import com.utn.auxiliar.Impresora;
import com.utn.controller.ApostadorController;
import com.utn.controller.ApuestaController;
import com.utn.controller.PartidoController;
import com.utn.controller.SeleccionadoController;
import com.utn.modelo.Apostador;
import com.utn.modelo.Apuesta;
import com.utn.modelo.Partido;
import com.utn.modelo.Seleccionado;

public class Main {
	public static void main(String[] args) {
		SeleccionadoController seleccionadoController = new SeleccionadoController();
		List<Seleccionado> listadoSeleccionados = seleccionadoController.listar();

		PartidoController partidoController = new PartidoController();
		List<Partido> listadoPartidos = partidoController.listar();

		ApostadorController apostadorController = new ApostadorController();
		List<Apostador> listadoApostadores = apostadorController.listar();

		ApuestaController apuestaController = new ApuestaController();
		List<Apuesta> listadoApuestas = apuestaController.listar();
	
		Calculadora calculadora = new Calculadora();
		Impresora impresora = new Impresora();
		
		
		Map<Integer, Integer> mapCantidadPartidosFases = calculadora.calculadoraPartidosPorFase(listadoPartidos);
		Map<Integer, Integer> mapCantidadPartidosRondas = calculadora.calculadoraPartidosPorRonda(listadoPartidos);

		listadoApostadores = calculadora.calcularPuntos(listadoApuestas, listadoApostadores, listadoPartidos);


		System.out.println("Nombre | Puntos" );
		System.out.println();
		for (Apostador apostador : listadoApostadores) {
			System.out.println(apostador.getNombre() + " | " + apostador.getPuntos());
			apostadorController.modificarPuntajeApostadorPorId(apostador.getId(), apostador.getPuntos());
			impresora.mostrarAciertosPorRonda(apostador.getMapPartidosAcertadosRondas(), mapCantidadPartidosRondas);
			System.out.println("");
			impresora.mostrarAciertosPorFase(apostador.getMapPartidosAcertadosFases(), mapCantidadPartidosFases);


		}

		
		
	}
}
