package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

	static private final String jdbcUrl = "jdbc:mysql://localhost/dizionario?user=root&password=corbezzoli95&serverTimezone=Europe/Rome";
	static private Connection connection = null;

	public static Connection getConnection() {

		try {
			
		    connection = DriverManager.getConnection(jdbcUrl);
			return connection;

		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException("Cannot get a connection " + jdbcUrl, e);
		}
	}

	
}
