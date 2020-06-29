package de.bruxxen.kindergarten.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import de.bruxxen.kindergarten.entity.Adress;
import de.bruxxen.kindergarten.entity.Person;
import de.bruxxen.kindergarten.entity.PhoneNumber;

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
													rs.getString("city"), 
													rs.getString("addition"), 
													rs.getInt("person_id"));
			adresses.add(adress);
		}
		this.connect.close();
		return adresses;
	}
	
	public ArrayList<Adress> getAdress(int id) throws SQLException{
		String sql = "SELECT * FROM adresses WHERE id =" + id;
		ResultSet rs = this.connect.getResultSet(sql);	
		ArrayList<Adress> resultArray = new ArrayList<Adress>();
		Adress adress = null;
		while (rs.next()) {
			adress = new Adress(rs.getInt("id"), 
											rs.getString("street"), 
											rs.getInt("plz"), 
											rs.getString("city"), 
											rs.getString("addition"), 
											rs.getInt("person_id"));
			resultArray.add(adress);	
		}
		this.connect.close();
		return resultArray;
	}

	public ArrayList<Adress> getAdress() throws SQLException{
		String sql = "SELECT * FROM adresses";
		ResultSet rs = this.connect.getResultSet(sql);	
		ArrayList<Adress> resultArray = new ArrayList<Adress>();
		Adress adress = null;
		while (rs.next()) {
			adress = new Adress(rs.getInt("id"), 
											rs.getString("street"), 
											rs.getInt("plz"), 
											rs.getString("city"), 
											rs.getString("addition"), 
											rs.getInt("person_id"));
			resultArray.add(adress);			
		}
		this.connect.close();
		return resultArray;
	}
	public ArrayList<Adress> getAllAdressesFromPerson(Person p) throws SQLException{
		String sql = "SELECT * FROM adresses WHERE person_id =" + p.getId();
		ResultSet rs = this.connect.getResultSet(sql);	
		ArrayList<Adress> resultArray = new ArrayList<Adress>();
		Adress a = null;
		while (rs.next()) {
			a = new Adress(rs.getInt("id"), 
										rs.getString("street"), 
										rs.getInt("plz"), 
										rs.getString("city"), 
										rs.getString("addition"), 
										rs.getInt("person_id"));
			resultArray.add(a);	
		}
		this.connect.close();
		return resultArray;
	}
	public void insertAdress(Adress a) throws SQLException{
		String sql = "INSERT INTO adresses (street, plz, city, person_id, addition) VALUES ('" +
				  										a.getStreet() + "', '"+
														a.getPlz() + "', '" +
														a.getCity() + "', '" +
														a.getPersonId() + "', '" +
														a.getAddition() + "');";
		this.connect.insertSet(sql);
		this.connect.close();
	}
	public void updateAdress(Adress a) throws SQLException{
		String sql = "UPDATE adresses SET street = '" + a.getStreet() + "', "+
											"plz = '" +	a.getPlz() + "', " +
											"city = '" +	a.getCity() + "', " +
											"addition = '" +a.getAddition() + "'"+
											"WHERE id = " + a.getId();
		this.connect.updateSet(sql);
		this.connect.close();
	}
	public void deleteAdress(Adress a) {
		String sql = "DELETE FROM adresses WHERE id = '" + a.getId() + "';";
		this.connect.deleteSet(sql);
		this.connect.close();
	}
}
