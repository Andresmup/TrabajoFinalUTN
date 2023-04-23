package com.utn.check;


import com.utn.modelo.Apostador;

public class CheckApostador extends Check {

	public boolean checkIntegridad(Apostador apostador) throws IllegalAccessException {
		if(apostador.getPuntos() < 0) {
			return false;
		}

		return super.checkIntegridad(apostador);
		
	    
	}
}
