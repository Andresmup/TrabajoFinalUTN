package com.utn.controller;

import java.util.List;

import com.utn.dao.ApostadorDAO;
import com.utn.factory.ConnectionFactory;
import com.utn.modelo.Apostador;


public class ApostadorController {
	private ApostadorDAO apostadorDAO;

	public ApostadorController() {
        var factory = new ConnectionFactory();
        this.apostadorDAO = new ApostadorDAO(factory.recuperarConexion());
	}
	
	
	public List<Apostador> listar() {
		return apostadorDAO.listar();

	}
	
	public int modificarPuntajeApostadorPorId(Integer id, Integer puntos) {
		return apostadorDAO.modificarPuntajeApostadorPorId(id, puntos);
	}
}
