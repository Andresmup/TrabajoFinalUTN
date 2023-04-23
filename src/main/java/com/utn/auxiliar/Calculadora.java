package com.utn.auxiliar;


import java.util.HashMap;

import java.util.List;
import java.util.Map;

import com.utn.modelo.Apostador;
import com.utn.modelo.Apuesta;
import com.utn.modelo.Partido;

public class Calculadora {



	public List<Apostador> calcularPuntos(List<Apuesta> listadoApuestas, List<Apostador> listadoApostadores,
			List<Partido> listadoPartidos) {

		Map<Integer, Integer> mapFases = calculadoraPartidosPorFase(listadoPartidos);
		Map<Integer, Integer> mapRondas = calculadoraPartidosPorRonda(listadoPartidos);


		for (Apostador apostador : listadoApostadores) {
			int puntos = apostador.getPuntos();


			Map<Integer, Integer> aciertosRondas = new HashMap<>();
			aciertosRondas.put(1, 0);
			Map<Integer, Integer> aciertosFases = new HashMap<>();
			aciertosFases.put(1, 0);

			for (Partido partido : listadoPartidos) {
				String ganador = partido.getGanador();

				for (Apuesta apuesta : listadoApuestas) {
					String resultadoEsperado = apuesta.getResultadoEsperado();
					
					if (apuesta.getPartido().getId() == partido.getId() && apuesta.getApostador().getId() == apostador.getId()) {

						if (resultadoEsperado.equals(ganador)) {
							puntos++;
							
							int fase = partido.getFase();
							
							if (aciertosFases.containsKey(fase)) {
								int partidosEnFase = aciertosFases.get(fase);
								aciertosFases.put(fase, partidosEnFase + 1);
							} else {
								aciertosFases.put(fase, 1);
							}

							int ronda = partido.getRonda();
							if (ronda != 0) {
								if (aciertosRondas.containsKey(ronda)) {
									int partidosEnRonda = aciertosRondas.get(ronda);
									aciertosRondas.put(ronda, partidosEnRonda + 1);
								} else {
									aciertosRondas.put(ronda, 1);
								}
							}

						}

					}

				}

			}
			
			for (Map.Entry<Integer, Integer> entry : mapRondas.entrySet()) {
				int ronda = entry.getKey();
				int valor = entry.getValue();

				if (aciertosRondas.containsKey(ronda) && aciertosRondas.get(ronda) == valor) {
					puntos++;
				}
			}

			for (Map.Entry<Integer, Integer> entry : mapFases.entrySet()) {
				int ronda = entry.getKey();
				int valor = entry.getValue();

				if (aciertosFases.containsKey(ronda) && aciertosFases.get(ronda) == valor) {
					puntos++;
				}
			}
			
			apostador.setMapPartidosAcertadosFases(aciertosFases);
			apostador.setMapPartidosAcertadosRondas(aciertosRondas);

			apostador.setPuntos(puntos);
		}
		return listadoApostadores;
	}

	public Map<Integer, Integer> calculadoraPartidosPorFase(List<Partido> listadoPartidos) {
		Map<Integer, Integer> partidosPorFase = new HashMap<>();
		for (Partido partido : listadoPartidos) {
			int fase = partido.getFase();
			if (partidosPorFase.containsKey(fase)) {
				int partidosEnFase = partidosPorFase.get(fase);
				partidosPorFase.put(fase, partidosEnFase + 1);
			} else {
				partidosPorFase.put(fase, 1);
			}
		}
		return partidosPorFase;
	}

	public Map<Integer, Integer> calculadoraPartidosPorRonda(List<Partido> listadoPartidos) {
		Map<Integer, Integer> partidosPorRonda = new HashMap<>();
		for (Partido partido : listadoPartidos) {
			int ronda = partido.getRonda();
			if (ronda != 0) {
				if (partidosPorRonda.containsKey(ronda)) {
					int partidosEnRonda = partidosPorRonda.get(ronda);
					partidosPorRonda.put(ronda, partidosEnRonda + 1);
				} else {
					partidosPorRonda.put(ronda, 1);
				}
			}
		}
		return partidosPorRonda;
	}
}
