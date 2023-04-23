package com.utn.controller;

import java.util.List;

import com.utn.dao.PartidoDAO;
import com.utn.factory.ConnectionFactory;
import com.utn.modelo.Partido;


public class PartidoController {
	private PartidoDAO partidoDAO;

	public PartidoController() {
        var factory = new ConnectionFactory();
        this.partidoDAO = new PartidoDAO(factory.recuperarConexion());
	}

	public List<Partido> listar() {
		return partidoDAO.listar();

	}
}
