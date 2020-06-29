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
import de.bruxxen.kindergarten.entity.Person;
import de.bruxxen.kindergarten.entity.PhoneNumber;

@Named
@SessionScoped
public class AdressenService implements Serializable {
	private static final long serialVersionUID = 1L;
	private DBAdresses dbAdressen = new DBAdresses();
	private ArrayList<Adress> tmpAdresses = new ArrayList<Adress>();
	private Adress emptyAdress = new Adress();
	@Inject
	private User user;
	@Inject
	private ListPersonenService lps;

	public AdressenService() {
		try {
			this.tmpAdresses = this.dbAdressen.getAdress();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Adress> getTmpAdresses() {
		return tmpAdresses;
	}
	public void setTmpAdresses(ArrayList<Adress> tmpAdresses) {
		this.tmpAdresses = tmpAdresses;
	}
	public void setTmpAdresses(Person p) {
		try {
			this.tmpAdresses = this.dbAdressen.getAllAdressesFromPerson(p);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Adress getEmptyAdress() {
		return emptyAdress;
	}
	public void setEmptyAdress(Adress emptyAdress) {
		this.emptyAdress = emptyAdress;
	}
	public ArrayList<Adress> getAdress(int id) {
		try {
			this.tmpAdresses = this.dbAdressen.getAdress(id); 
			return this.tmpAdresses;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<Adress> getAdress() {
		try {
			this.tmpAdresses = this.dbAdressen.getAdress(); 
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
	public String updateAdress(Adress a, String nav) {
		try {
			this.dbAdressen.updateAdress(a);
			System.out.print(a.getPersonId());
			return this.lps.navEditPerson(a.getPersonId());
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return nav;
	}
	public String insertAdress(Adress a) {
		try {
			System.out.print(a.toString());
			this.dbAdressen.insertAdress(a);
			this.emptyAdress = null;
			return lps.navEditPerson(a);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return "";
	}
	public String deleteAdress(Adress a) {
		this.dbAdressen.deleteAdress(a);	
		return lps.navEditPerson(a);
	}
	public String addNewA(Person p) {
		this.setEmptyAdress(new Adress(p.getId()));
		return "insertAdresse.xhtml";
	}
}
