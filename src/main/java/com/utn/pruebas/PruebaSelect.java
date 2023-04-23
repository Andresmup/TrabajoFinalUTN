package com.utn.pruebas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




import com.utn.factory.ConnectionFactory;


public class PruebaSelect {
	public static void main(String[] args) throws SQLException {
		Connection con = new ConnectionFactory().recuperarConexion();
		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM seleccionados");

		while (resultSet.next()) {
			String seleccionID = resultSet.getString("SeleccionID");
			String nombre = resultSet.getString("Nombre");

			System.out.format(seleccionID + ", " + nombre + "\n");
		}
		
		

		
		con.close();
	}
	
}
