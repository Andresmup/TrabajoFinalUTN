package com.utn.pruebas;


import java.util.List;
import com.utn.controller.SeleccionadoController;
import com.utn.modelo.Seleccionado;

public class PruebaSeleccionado {
	public static void main(String[] args) {		
		SeleccionadoController sc = new SeleccionadoController();
		
		
		List<Seleccionado> listado = sc.listar();
		System.out.println("ID | SELECCION | DESCRIPCCION");
		for (Seleccionado seleccion: listado) {
				System.out.println(seleccion.getId() + " " + seleccion.getNombre() + " " + seleccion.getDescripcion());

		}

		
	}
}
