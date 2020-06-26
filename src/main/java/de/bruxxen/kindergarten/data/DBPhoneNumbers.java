package de.bruxxen.kindergarten.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import de.bruxxen.kindergarten.entity.Adress;
import de.bruxxen.kindergarten.entity.PhoneNumber;

public class DBPhoneNumbers {
	private DBConnect connect = new DBConnect();
	
	public ArrayList<PhoneNumber> getPhoneNumber(int id) throws SQLException{
		String sql = "SELECT * FROM phoneNumbers WHERE id =" + id;
		ResultSet rs = this.connect.getResultSet(sql);	
		ArrayList<PhoneNumber> resultArray = new ArrayList<PhoneNumber>();
		PhoneNumber pn = null;
		while (rs.next()) {
			pn = new PhoneNumber(rs.getInt("id"), 
										rs.getInt("phoneNumber"), 
										rs.getInt("id_person"));
			resultArray.add(pn);	
		}
		this.connect.close();
		return resultArray;
	}
	public ArrayList<PhoneNumber> getAllPhoneNumbersFromPerson(int id) throws SQLException{
		String sql = "SELECT * FROM phoneNumbers WHERE id_person =" + id;
		ResultSet rs = this.connect.getResultSet(sql);	
		ArrayList<PhoneNumber> resultArray = new ArrayList<PhoneNumber>();
		PhoneNumber pn = null;
		while (rs.next()) {
			pn = new PhoneNumber(rs.getInt("id"), 
										rs.getInt("phoneNumber"), 
										rs.getInt("id_person"));
			resultArray.add(pn);	
		}
		this.connect.close();
		return resultArray;
	}
	public ArrayList<PhoneNumber> getPhoneNumber() throws SQLException{
		String sql = "SELECT * FROM phoneNumbers";
		ResultSet rs = this.connect.getResultSet(sql);	
		ArrayList<PhoneNumber> resultArray = new ArrayList<PhoneNumber>();
		PhoneNumber pn = null;
		while (rs.next()) {
			pn = new PhoneNumber(rs.getInt("id"), 
										rs.getInt("phoneNumber"), 
										rs.getInt("id_person"));
			resultArray.add(pn);			
		}
		this.connect.close();
		return resultArray;
	}
	public void insertPhoneNumber(PhoneNumber pn) throws SQLException{
		String sql = "INSERT INTO phoneNumbers (phoneNumbers, id_person) VALUES ('" +
														pn.getPhoneNumber() + "', '"+
														pn.getId_person() + "');";
		this.connect.insertSet(sql);
		this.connect.close();
	}
	public void updatePhoneNumber(PhoneNumber pn) throws SQLException{
		String sql = "UPDATE phoneNumbers SET phoneNumber = '" + pn.getPhoneNumber() + "', "+
											"id_person = '" +pn.getId_person() + "'"+
											"WHERE id = " + pn.getId();
		this.connect.updateSet(sql);
		this.connect.close();
	}
	public void deletePhoneNumber(PhoneNumber pn) {
		String sql = "DELETE FROM phoneNumbers WHERE id = '" + pn.getId() + "';";
		this.connect.deleteSet(sql);
		this.connect.close();
	}

}
