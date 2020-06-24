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
			private Connection connect = null;
			private PreparedStatement pstmt;
			private ResultSet rs;
			static final String username = "kindergarten";
			static final String password = "password";
			static final String url = "jdbc:mysql://localhost:3306/kindergarten";
		   
			public DBConnect() {

			}
		   
		   private void setConnection() throws Throwable {
					Class.forName("com.mysql.cj.jdbc.Driver");
					connect = DriverManager.getConnection(url, username, password);
		   }

		   
		   public ArrayList<Adress> getAdress(){
			   try {
				this.setConnection();
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

				ArrayList<Adress> adresses = new ArrayList<Adress>();
				try {
					pstmt = connect.prepareStatement("select plz, city, street FROM adresses");
					rs = pstmt.executeQuery();
					while (rs.next()) {
						Adress adress = new Adress(rs.getString("street"), rs.getInt("plz"), rs.getString("city"));
						adresses.add(adress);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				this.close();
				return adresses;
		   }
		   
		  private void close(){
			  try {
				  this.rs.close();
				  this.pstmt.close();
				  this.connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		  }
		  
		  public ResultSet getResultSet(String sqlStatement) {
			  try {
				  this.setConnection();
				  pstmt = connect.prepareStatement(sqlStatement);
				  rs = pstmt.executeQuery();
				  return rs;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  return null;	  
		  }
		  
		  public String getvalueList(ArrayList values) {
			  String result = "(";
			  for (int i = 0; i < values.size(); i++) {
				  result = result + values.get(i) + ", ";
			  }
			  result.substring(result.length()-2);
			  result = result + ")";
			  System.out.print(result);
			  return result;
		  }
}
