package com.utn.controller;

import java.util.List;

import com.utn.dao.ApuestaDAO;
import com.utn.factory.ConnectionFactory;
import com.utn.modelo.Apuesta;

public class ApuestaController {

	private ApuestaDAO apuestaDAO;

	public ApuestaController() {
        var factory = new ConnectionFactory();
        this.apuestaDAO = new ApuestaDAO(factory.recuperarConexion());
	}

	public List<Apuesta> listar() {
		return apuestaDAO.listar();

	}


}
