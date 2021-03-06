package de.bruxxen.kindergarten.entity;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import de.bruxxen.kindergarten.data.DBAdresses;
import de.bruxxen.kindergarten.entity.Adress;

@Named
@SessionScoped
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String username, password;

	private String tmpUsername, tmpPassword;
	private int id;
	private int securityLvl = 0;

	
	public User() {
		
	}
	public User(int id, String username, String password, int securityLvl) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.securityLvl = securityLvl;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTmpUsername() {
		return tmpUsername;
	}
	public void setTmpUsername(String tmpUsername) {
		this.tmpUsername = tmpUsername;
	}
	public String getTmpPassword() {
		return tmpPassword;
	}
	public void setTmpPassword(String tmpPassword) {
		this.tmpPassword = tmpPassword;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSecurityLvl() {
		return securityLvl;
	}
	public void setSecurityLvl(int securityLvl) {
		this.securityLvl = securityLvl;
	}
	public void logOutUser() {
		this.id = 0;
		this.username = "";
		this.password = "";
		this.securityLvl = 0;
	}
	
	
	
	
}
