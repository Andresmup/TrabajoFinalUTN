package com.utn.pruebas;

import java.sql.Connection;
import java.sql.SQLException;

import com.utn.factory.ConnectionFactory;

public class PruebaConexion {
	public static void main(String[] args) throws SQLException {
		Connection con = new ConnectionFactory().recuperarConexion();

		System.out.println("Cerrando la conexion");

		con.close();
	}
}
