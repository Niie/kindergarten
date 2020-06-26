package de.bruxxen.kindergarten.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import de.bruxxen.kindergarten.entity.Person;

public class DBPersonen {
	private DBConnect connect = new DBConnect();
	
	public ArrayList<Person> getAllpersons() throws SQLException{
		ArrayList<Person> resultArray = new ArrayList<Person>();
		String sql = "SELECT * FROM persons";
		ResultSet rs = this.connect.getResultSet(sql);		
		while (rs.next()) {
			Person p = new Person(rs.getInt("id"), 
										rs.getString("firstName"), 
										rs.getString("lastName"));
			resultArray.add(p);
		}
		this.connect.close();
		return resultArray;
	}
	
	public ArrayList<Person> getPerson(int id) throws SQLException{
		ArrayList<Person> resultArray = new ArrayList<Person>();
		String sql = "SELECT * FROM persons WHERE id =" + id;
		ResultSet rs = this.connect.getResultSet(sql);	
		while (rs.next()) {
			Person p = new Person(rs.getInt("id"), 
										rs.getString("firstName"), 
										rs.getString("lastName"));
			resultArray.add(p);	
		}
		this.connect.close();
		return resultArray;
	}
	public ArrayList<Person> getPerson() throws SQLException{
		ArrayList<Person> resultArray = new ArrayList<Person>();	
		String sql = "SELECT * FROM persons";
		ResultSet rs = this.connect.getResultSet(sql);	
		while (rs.next()) {
			Person p = new Person(rs.getInt("id"), 
										rs.getString("firstName"), 
										rs.getString("lastName"));
			resultArray.add(p);			
		}
		this.connect.close();
		return resultArray;
	}
	public void insertPerson(Person p) throws SQLException{
		String sql = "INSERT INTO persons (firstName, lastName) VALUES ('" +
				  										p.getFirstName() + "', '"+
														p.getLastName() + "');";
		this.connect.insertSet(sql);
		this.connect.close();
	}
	public void updatePerson(Person p) throws SQLException{
		String sql = "UPDATE persons SET firstName = '" + p.getFirstName() + "', "+
											"lastName = '" +	p.getLastName() + "' " +
											"WHERE id = " + p.getId();
		this.connect.updateSet(sql);
		this.connect.close();
	}
	public void deletePerson(Person p) {
		String sql = "DELETE FROM persons WHERE id = '" + p.getId() + "';";
		this.connect.deleteSet(sql);
		this.connect.close();
	}
}
