package de.bruxxen.kindergarten.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Statement;

import de.bruxxen.kindergarten.entity.Adress;

public class DBConnect {
		   // JDBC driver name and database URL
			Connection connect = null;

			String url = "jdbc:mysql://localhost:3306/kindergarten";

		   //  Database credentials
		   static final String username = "kindergarten";
		   static final String password = "password";

		   
		   public ArrayList<Adress> getAdress() throws SQLException, ClassNotFoundException {
			   try {
				   System.out.println("Connectetd");
					Class.forName("com.mysql.cj.jdbc.Driver");

					connect = DriverManager.getConnection(url, username, password);
					 System.out.println("Connection established"+connect);

				} catch (SQLException ex) {
					System.out.println("in exec");
					System.out.println(ex.getMessage());
				}

				ArrayList<Adress> adresses = new ArrayList<Adress>();
				PreparedStatement pstmt = connect
						.prepareStatement("select plz, city, street FROM adresses");
				
				
				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {

					Adress adress = new Adress(rs.getString("street"), rs.getInt("plz"), rs.getString("city"));

					adresses.add(adress);

				}

				// close resources
				rs.close();
				pstmt.close();
				connect.close();

				return adresses;
		   }
		   
		  
}
