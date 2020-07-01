package de.bruxxen.kindergarten.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import de.bruxxen.kindergarten.entity.User;

public class DBUser {
	private DBConnect connect = new DBConnect();
	
	public ArrayList<User> getAllUser() throws SQLException{
		ArrayList<User> resultArray = new ArrayList<User>();
		String sql = "SELECT * FROM user";
		ResultSet rs = this.connect.getResultSet(sql);
		
		
		while (rs.next()) {
			User user = new User(rs.getInt("id"), 
													rs.getString("username"), 
													rs.getString("password"), 
													rs.getInt("securityLvl"));
			resultArray.add(user);
		}
		this.connect.close();
		return resultArray;
	}
	
	public ArrayList<User> getUser(int id) throws SQLException{
		String sql = "SELECT * FROM user WHERE id = '" + id + "';";
		ResultSet rs = this.connect.getResultSet(sql);	
		ArrayList<User> resultArray = new ArrayList<User>();
		while (rs.next()) {
			User user = new User(rs.getInt("id"), 
													rs.getString("username"), 
													rs.getString("password"), 
													rs.getInt("securityLvl"));
			resultArray.add(user);
		}
		this.connect.close();
		return resultArray;
	}
	
	public ArrayList<User> getUser(String username) throws SQLException{
		String sql = "SELECT * FROM user WHERE username = '" + username + "';";
		ResultSet rs = this.connect.getResultSet(sql);	
		ArrayList<User> resultArray = new ArrayList<User>();
		while (rs.next()) {
			User user = new User(rs.getInt("id"), 
													rs.getString("username"), 
													rs.getString("password"), 
													rs.getInt("securityLvl"));
			resultArray.add(user);
		}
		this.connect.close();
		return resultArray;
	}

	public ArrayList<User> getUser() throws SQLException{
		ArrayList<User> resultArray = new ArrayList<User>();
		String sql = "SELECT * FROM user";
		ResultSet rs = this.connect.getResultSet(sql);
		
		
		while (rs.next()) {
			User user = new User(rs.getInt("id"), 
													rs.getString("username"), 
													rs.getString("password"), 
													rs.getInt("securityLvl"));
			resultArray.add(user);
		}
		this.connect.close();
		return resultArray;
	}
	public ArrayList<User> getUser(User u) throws SQLException{
		if (u.getId() != 0)	return this.getUser(u.getId());
		else return this.getUser(u.getUsername());
	}


	public void insertUser(User u) throws SQLException{
		String sql = "INSERT INTO user (username, password, securityLvl) VALUES ('" +
			  										u.getId() + "', '"+
													u.getUsername() + "', '" +
													u.getpassword() + "', '" +
													u.getSecurityLvl() + "');";
		this.connect.insertSet(sql);
		this.connect.close();
	}
	public void updateUser(User u) throws SQLException{
		String sql = "UPDATE user SET username = '" + u.getUsername() + "', "+
													"password = '" +	u.getpassword() + "', " +
													"securityLvl = '" +	u.getSecurityLvl() + "', " +
													"WHERE id = " + u.getId();
		this.connect.updateSet(sql);
		this.connect.close();
	}
	public void deleteUser(User u) {
		String sql = "DELETE FROM user WHERE id = '" + u.getId() + "';";
		this.connect.deleteSet(sql);
		this.connect.close();
	}
}
