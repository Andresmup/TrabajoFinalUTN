package com.utn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.utn.check.CheckPartido;
import com.utn.modelo.Partido;
import com.utn.utils.SelectorSeleccionado;

public class PartidoDAO {
	final private Connection con;
	

	public PartidoDAO(Connection con) {
		this.con = con;
	}

	public List<Partido> listar() {
		List<Partido> resultado = new ArrayList<>();
		SelectorSeleccionado sc = new SelectorSeleccionado();
		CheckPartido check = new CheckPartido();
		try {
			final PreparedStatement statement = con.prepareStatement(
					"SELECT PartidoID, EquipoUno, EquipoDos, GolesEquipoUno, GolesEquipoDos, Ronda, Fase, Ganador FROM resultados;");
			try (statement) {
				statement.execute();
				ResultSet resultSet = statement.getResultSet();

				while (resultSet.next()) {

					Partido fila = new Partido(resultSet.getInt("PartidoID"), sc.recuperarSeleccion(resultSet.getString("EquipoUno")),
							sc.recuperarSeleccion(resultSet.getString("EquipoDos")), resultSet.getInt("GolesEquipoUno"),
							resultSet.getInt("GolesEquipoDos"), resultSet.getInt("Ronda"), resultSet.getInt("Fase"),
							resultSet.getString("Ganador"));

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
