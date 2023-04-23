package com.utn.auxiliar;

import java.util.Map;

public class Impresora {
	public void mostrarAciertosPorRonda(Map<Integer, Integer> mapAciertos,Map<Integer, Integer> mapReal){
		
		for (Map.Entry<Integer, Integer> entry : mapReal.entrySet()) {
			int ronda = entry.getKey();
			float valor = entry.getValue();

			if (mapAciertos.containsKey(ronda)) {
				float porcentajeAcierto = (mapAciertos.get(ronda)/valor)*100;
				System.out.println("En la ronda: " + ronda + " acerto " + mapAciertos.get(ronda) + " resultados de " + (int) valor);
				System.out.println("Tuvo un porcentaje de aciertos: " + porcentajeAcierto);
				System.out.println("");
			}
		}
		
	}
	
	public void mostrarAciertosPorFase(Map<Integer, Integer> mapAciertos,Map<Integer, Integer> mapReal){
		
		for (Map.Entry<Integer, Integer> entry : mapReal.entrySet()) {
			int fase = entry.getKey();
			float valor = entry.getValue();

			if (mapAciertos.containsKey(fase)) {
				float porcentajeAcierto = (mapAciertos.get(fase)/valor)*100;
				System.out.println("En la fase: " + fase + " acerto " + mapAciertos.get(fase) + " resultados de " + (int) valor);
				System.out.println("Tuvo un porcentaje de aciertos: " + porcentajeAcierto);
				System.out.println("");
			}
		}
		
	}
}
