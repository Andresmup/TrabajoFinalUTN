package com.utn.check;


import com.utn.modelo.Partido;

public class CheckPartido extends Check {

	public boolean checkIntegridad(Partido partido) throws IllegalAccessException {
		if(partido.getGolesEquipoUno() < 0) {
			return false;
		}
		if(partido.getGolesEquipoDos() < 0) {
			return false;
		}
		if(partido.getRonda() < 0) {
			return false;
		}
		if(partido.getRonda() != 0 && partido.getFase() != 1) {
			return false;
		}
		if(partido.getEquipoUno().equals(partido.getEquipoDos())) {
			return false;
		}
		return super.checkIntegridad(partido);
		
	    
	}
}
