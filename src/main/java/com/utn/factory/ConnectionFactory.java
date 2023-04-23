package com.utn.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	private DataSource datasource;
	public ConnectionFactory() {
		var pooledDataSource = new ComboPooledDataSource();
		pooledDataSource.setJdbcUrl("jdbc:mysql://localhost/control_de_apuestas?useUnicode=true&useTimeZone=true&serverTimeZone=UTC&characterEncoding=UTF-8");
		pooledDataSource.setUser("root");
		pooledDataSource.setPassword("admin");
		pooledDataSource.setMaxPoolSize(10);
		this.datasource = pooledDataSource;
	}
	
	
	public Connection recuperarConexion(){
		try {
			return this.datasource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
