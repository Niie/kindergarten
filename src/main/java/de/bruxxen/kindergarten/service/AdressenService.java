package de.bruxxen.kindergarten.service;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.bruxxen.kindergarten.User;
import de.bruxxen.kindergarten.data.DBAdresses;
import de.bruxxen.kindergarten.entity.Adress;

@Named
@SessionScoped
public class AdressenService implements Serializable {
	private static final long serialVersionUID = 1L;
	private DBAdresses dbAdressen = new DBAdresses();
	private ArrayList<Adress> tmpAdresses = new ArrayList<Adress>();
	@Inject
	private User user;
	
	public ArrayList<Adress> getTmpAdresses() {
		return tmpAdresses;
	}
	public void setTmpAdresses(ArrayList<Adress> tmpAdresses) {
		this.tmpAdresses = tmpAdresses;
	}
	public ArrayList<Adress> getAdress() {
		try {
			this.tmpAdresses.clear();
			this.tmpAdresses.add(this.dbAdressen.getAdress(this.user.getTmpID())); 
			return this.tmpAdresses;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void updateAdress(Adress a) {
		try {
			this.dbAdressen.updateAdress(a);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
