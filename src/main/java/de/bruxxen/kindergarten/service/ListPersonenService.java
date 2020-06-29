package de.bruxxen.kindergarten.service;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.bruxxen.kindergarten.User;
import de.bruxxen.kindergarten.entity.Person;
import de.bruxxen.kindergarten.entity.PhoneNumber;

@Named
@RequestScoped
public class ListPersonenService {
	@Inject
	User user;
	@Inject
	PersonenService pService;
	@Inject
	PhoneNumberService pnService;

	public String navEditPerson(Person p) {
		this.pService.setTmpPersons(this.pService.getPerson(p.getId()));
		this.pnService.setTmpPhoneNumbers(p);
		return "editPerson.xhtml";	
	}
	public String navEditPerson(int id) {
		ArrayList<Person> p = pService.getPerson(id);
		this.pService.setTmpPersons(this.pService.getPerson(p.get(0).getId()));
		this.pnService.setTmpPhoneNumbers(p.get(0));
		return "editPerson.xhtml";	
	}
	public String navListPerson() {
		this.pService.setTmpPersons(this.pService.getPerson());
		return "listPerson.xhtml";	
	}
	public String navNewPerson() {
		return "insertPerson.xhtml";	
	}
}
