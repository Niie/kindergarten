package de.bruxxen.kindergarten.service;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.bruxxen.kindergarten.entity.User;
import de.bruxxen.kindergarten.data.DBPersonen;
import de.bruxxen.kindergarten.entity.Person;

@Named
@SessionScoped
public class PersonenService implements Serializable {
	private static final long serialVersionUID = 1L;
	private DBPersonen dbPersons = new DBPersonen();
	private ArrayList<Person> tmpPersons = new ArrayList<Person>();
	private Person emptyPerson = new Person();
	@Inject
	private User user;

	public PersonenService() {
		try {
			this.tmpPersons = this.dbPersons.getPerson();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Person> getTmpPersons() {
		System.out.print(" getTmpPerson: " + this.user.getSecurityLvl());
		if (user.getSecurityLvl() > 2) return tmpPersons;
		else return null;
	}
	public void setTmpPersons(ArrayList<Person> tmpPersons) {
		this.tmpPersons = tmpPersons;
	}
	public Person getEmptyPerson() {
		return emptyPerson;
	}
	public void setEmptyPerson(Person emptyPerson) {
		this.emptyPerson = emptyPerson;
	}
	public ArrayList<Person> getPerson(int id) {
		try {
			this.tmpPersons = this.dbPersons.getPerson(id); 
			return this.tmpPersons;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<Person> getPerson() {
		try {
			this.tmpPersons = this.dbPersons.getPerson(); 
			return this.tmpPersons;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void updatePerson(Person a) {
		try {
			this.dbPersons.updatePerson(a);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	public String updatePerson(Person a, String nav) {
		try {
			this.dbPersons.updatePerson(a);
			this.tmpPersons = this.dbPersons.getPerson();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return nav;
	}
	public String insertPerson(Person a) {
		try {
			this.dbPersons.insertPerson(a);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return "listPerson.xhtml";
	}
	public void deletePerson(Person a) {
		this.dbPersons.deletePerson(a);	
	}
}
