package de.bruxxen.kindergarten.service;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.bruxxen.kindergarten.data.DBUser;
import de.bruxxen.kindergarten.entity.User;

@Named
@SessionScoped
public class UserService implements Serializable{
	private static final long serialVersionUID = 1L;
	DBUser dbUser = new DBUser();
	@Inject
	User user;
	@Inject
	ListPersonenService lps;
	
	public String logIn() {
		try {
			ArrayList<User> user = dbUser.getUser(this.user.getTmpUsername());
			if (user.size()>0) {
				if (user.get(0).getpassword().equals(this.user.getTmpPassword())) {
					this.user.setUsername(this.user.getTmpUsername());
					this.user.setSecurityLvl(user.get(0).getSecurityLvl());
					return lps.navListPerson();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
	public void instaLogIn() {
		this.user.setId(1);
		this.user.setSecurityLvl(5);
		this.user.setUsername("InstaLogIn");
	}
	public String logOut() {
		this.user.logOutUser();
		return "index.xhtml";
	}
}
