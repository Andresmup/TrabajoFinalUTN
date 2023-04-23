package com.utn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.utn.check.CheckApostador;
import com.utn.modelo.Apostador;

public class ApostadorDAO {
	final private Connection con;

	public ApostadorDAO(Connection con) {
		this.con = con;
	}
	
	public List<Apostador> listar() {
		List<Apostador> resultado = new ArrayList<>();
		CheckApostador check = new CheckApostador();
		try  {
			final PreparedStatement statement = con.prepareStatement("SELECT ApostadorID, Nombre, Apellido, Puntos FROM apostadores;");
			try (statement) {
				statement.execute();
				ResultSet resultSet = statement.getResultSet();

				while (resultSet.next()) {
					Apostador fila = new Apostador(resultSet.getInt("ApostadorID"), resultSet.getString("Nombre"),
							resultSet.getString("Apellido"), resultSet.getInt("Puntos"));
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
	
	public int modificarPuntajeApostadorPorId(Integer id, Integer puntos) {

        try {
            final PreparedStatement statement = con.prepareStatement(
                    "UPDATE apostadores SET "
                    + " Puntos = ?"
                    + " WHERE ApostadorID = ?");

            try (statement) {
            	statement.setInt(1, puntos);
                statement.setInt(2, id);
                statement.execute();

                int updateCount = statement.getUpdateCount();

                return updateCount;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

	}
}
