package de.bruxxen.kindergarten.service;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.bruxxen.kindergarten.User;
import de.bruxxen.kindergarten.entity.Adress;
import de.bruxxen.kindergarten.entity.Person;
import de.bruxxen.kindergarten.entity.PhoneNumber;

@Named
@RequestScoped
public class ListPersonenService {
	@Inject
	User user;
	@Inject
	PersonenService pService = new PersonenService();
	@Inject
	PhoneNumberService pnService = new PhoneNumberService();
	@Inject
	AdressenService aService = new AdressenService();

	public String navEditPerson(Person p) {
		if (p != null) {
			this.pService.setTmpPersons(this.pService.getPerson(p.getId()));
			this.pnService.setTmpPhoneNumbers(p);
			this.aService.setTmpAdresses(p);
			
		}
		return "editPerson.xhtml";	
	}
	public String navEditPerson(int id) {
		ArrayList<Person> pl = pService.getPerson(id);
		Person p = pl.get(0);
		return this.navEditPerson(p);
	}
	public String navEditPerson(PhoneNumber pn) {
		ArrayList<Person> pl = pService.getPerson(pn.getId_person());
		Person p = pl.get(0);
		return this.navEditPerson(p);
	}
	public String navEditPerson(Adress a) {
		ArrayList<Person> pl = pService.getPerson(a.getPersonId());
		Person p = null;
		if (pl.size() > 0) p = pl.get(0);
		return this.navEditPerson(p);
	}
	public String navListPerson() {
		this.pService.setTmpPersons(this.pService.getPerson());
		return "listPerson.xhtml";	
	}
	public String navNewPerson() {
		return "insertPerson.xhtml";	
	}
}
