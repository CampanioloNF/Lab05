package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class AnagrammaDAO {

	public boolean isCorrect(String anagramma) {
		
		
		final String sql = "SELECT * FROM parola WHERE nome = ?";
				
	
				try {
					
					Connection conn = ConnectDB.getConnection();
					
					PreparedStatement st = conn.prepareStatement(sql);
					st.setString(1, anagramma);
					
					ResultSet rs = st.executeQuery();
					
					boolean result;
					
					if(rs.next())
						result = true;
					else
						result = false;
					
					conn.close();
					
					return result;
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return false;
		
		
	}
	
}
