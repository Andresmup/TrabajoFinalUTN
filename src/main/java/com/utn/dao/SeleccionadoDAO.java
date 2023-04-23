package com.utn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.utn.check.Check;


import com.utn.modelo.Seleccionado;

public class SeleccionadoDAO {
	
	final private Connection con;

	
	public SeleccionadoDAO(Connection con) {
		this.con = con;
	}
	
	public List<Seleccionado> listar() {
		List<Seleccionado> resultado = new ArrayList<>();
		Check check = new Check();
		try  {
			final PreparedStatement statement = con.prepareStatement("SELECT SeleccionID, Nombre, Descripcion FROM seleccionados;");
			try (statement) {
				statement.execute();
				ResultSet resultSet = statement.getResultSet();

				while (resultSet.next()) {
					Seleccionado fila = new Seleccionado(resultSet.getString("SeleccionID"), resultSet.getString("Nombre"),resultSet.getString("Descripcion"));
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
