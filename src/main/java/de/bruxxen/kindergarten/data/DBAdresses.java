package de.bruxxen.kindergarten.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import de.bruxxen.kindergarten.entity.Adress;

public class DBAdresses {
	private DBConnect connect = new DBConnect();
	
	public ArrayList<Adress> getAllAdresses() throws SQLException{
		ArrayList<Adress> adresses = new ArrayList<Adress>();
		String sql = "SELECT * FROM adresses";
		ResultSet rs = this.connect.getResultSet(sql);
		
		
		while (rs.next()) {
			Adress adress = new Adress(rs.getInt("id"), 
										rs.getString("street"), 
										rs.getInt("plz"), 
										rs.getString("city"),rs.getString("addition"));
			adresses.add(adress);
		}
		this.connect.close();
		return adresses;
	}
	public Adress getAdress(int id) throws SQLException{
		String sql = "SELECT * FROM adresses WHERE " + id;
		ResultSet rs = this.connect.getResultSet(sql);	
		Adress adress = null;
		while (rs.next()) {
			adress = new Adress(rs.getInt("id"), 
										rs.getString("street"), 
										rs.getInt("plz"), 
										rs.getString("city"),
										rs.getString("addition"));
		}
		this.connect.close();
		return adress;
	}
	public void insertAdress(Adress a) throws SQLException{
		ArrayList<Adress> adresses = new ArrayList<Adress>();
		String sql = "INSERT INTO adresses VALUES (" + a.getStreet() + ", "+
														a.getPlz() + ", " +
														a.getCity() + ", " +
														a.getAddition() + ");";
		this.connect.getResultSet(sql);
		this.connect.close();
	}
	public void updateAdress(Adress a) throws SQLException{
		String sql = "UPDATE adresses SET (street = " + a.getStreet() + ", "+
											"plz = " +	a.getPlz() + ", " +
											"city = " +	a.getCity() + ", " +
											"addition = " +a.getAddition() + ")"+
											"WHERE id == " + a.getId();
		this.connect.getResultSet(sql);
		this.connect.close();
	}

}
