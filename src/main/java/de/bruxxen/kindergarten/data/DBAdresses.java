package de.bruxxen.kindergarten.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import de.bruxxen.kindergarten.entity.Adress;

public class DBAdresses {
	private DBConnect connect = new DBConnect();
	
	public Adress getAdress(int id) {
		ResultSet rs = this.connect.getResultSet("select id, plz, city, street, addition FROM adresses WHERE id = '1'");
		try {
			if(rs != null) {
				if(rs.next()) {
					Adress adress = new Adress(rs.getInt("id"), rs.getString("street"), rs.getInt("plz"), rs.getString("city"), rs.getString("addition"));
					return adress;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void setAdress(Adress adress) {
		ArrayList<String> aList = new ArrayList<String>(); 
		aList.add(adress.getStreet());
		aList.add(adress.getCity());
		aList.add(String.valueOf(adress.getPlz()));
		aList.add(adress.getAddition());
		String values = this.connect.getvalueList(aList);
		ResultSet rs;
		if(adress.getId() != 0) {
			rs = this.connect.getResultSet("INSERT INTO adresses (street, city, plz, addition) VALUES " + values);
		}
		
		
	//	"INSERT INTO adresses (street, city, plz, addition) VALUES(1, "A", 19) ON DUPLICATE KEY UPDATE    
		//name="A", age=19
	}

}
