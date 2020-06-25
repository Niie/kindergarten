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
	private Adress emptyAdress = new Adress();
	@Inject
	private User user;
	
	public ArrayList<Adress> getTmpAdresses() {
		this.tmpAdresses.clear();
		try {
			this.tmpAdresses.add(this.dbAdressen.getAdress(this.user.getTmpID()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tmpAdresses;
	}
	public void setTmpAdresses(ArrayList<Adress> tmpAdresses) {
		this.tmpAdresses = tmpAdresses;
	}
	public Adress getEmptyAdress() {
		return emptyAdress;
	}
	public void setEmptyAdress(Adress emptyAdress) {
		this.emptyAdress = emptyAdress;
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
	public void insertAdress(Adress a) {
		try {
			this.dbAdressen.insertAdress(a);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	public void deleteAdress(Adress a) {
		this.dbAdressen.deleteAdress(a);	
	}
}
