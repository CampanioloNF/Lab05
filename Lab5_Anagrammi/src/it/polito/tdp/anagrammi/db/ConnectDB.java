package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

public class ConnectDB {

private static HikariDataSource ds = null;

	public static Connection getConnection(){

	 String jdbc = "jdbc:mysql://localhost/dizionario";
	
	 try{
 
	   if(ds == null){

	       ds = new HikariDataSource();

	       ds.setJdbcUrl(jdbc);
	       ds.setUsername("root");
	       ds.setPassword("");
	    }
	
	    Connection conn = ds.getConnection();

		return conn;

	   
     	}
	catch (SQLException e) {

		e.printStackTrace();
		throw new RuntimeException("Cannot get a connection " + jdbc, e);
	}

  }
	
}
