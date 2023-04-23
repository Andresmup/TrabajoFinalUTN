package com.utn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.utn.check.Check;
import com.utn.modelo.Apuesta;
import com.utn.utils.SelectorApostador;
import com.utn.utils.SelectorPartido;

public class ApuestaDAO {
	final private Connection con;

	public ApuestaDAO(Connection con) {
		this.con = con;
	}
	

	public List<Apuesta> listar() {
		List<Apuesta> resultado = new ArrayList<>();
		SelectorApostador sa = new SelectorApostador();
		SelectorPartido sp = new SelectorPartido();
		Check check = new Check();
		try  {
			final PreparedStatement statement = con.prepareStatement("SELECT ApuestaID, ApostadorID, PartidoID, ResultadoEsperado FROM apuestas;");
			try (statement) {
				statement.execute();
				ResultSet resultSet = statement.getResultSet();

				while (resultSet.next()) {
					Apuesta fila = new Apuesta(resultSet.getInt("ApuestaID"), sa.recuperarApostador(resultSet.getInt("ApostadorID")),
					sp.recuperarPartido(resultSet.getInt("PartidoID")), resultSet.getString("ResultadoEsperado"));


					try {
						if (check.checkIntegridad(fila)) {
							resultado.add(fila);
						}
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}


				}
				return resultado;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	


}
