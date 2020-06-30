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
	
	public void logIn() {
		try {
			ArrayList<User> user = dbUser.getUser(this.user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
