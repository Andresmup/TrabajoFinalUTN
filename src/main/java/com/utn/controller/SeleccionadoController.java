package com.utn.controller;

import java.util.List;


import com.utn.dao.SeleccionadoDAO;
import com.utn.factory.ConnectionFactory;
import com.utn.modelo.Seleccionado;

public class SeleccionadoController {
	private SeleccionadoDAO seleccionadoDAO;

	public SeleccionadoController() {
        var factory = new ConnectionFactory();
        this.seleccionadoDAO = new SeleccionadoDAO(factory.recuperarConexion());
	}

	public List<Seleccionado> listar() {
		return seleccionadoDAO.listar();

	}
	
}
