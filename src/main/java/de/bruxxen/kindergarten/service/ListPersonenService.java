package de.bruxxen.kindergarten.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.bruxxen.kindergarten.User;
import de.bruxxen.kindergarten.entity.Person;

@Named
@RequestScoped
public class ListPersonenService {
	@Inject
	User user;
	@Inject
	PersonenService pService;

	public String navEditPerson(Person a) {
		this.pService.setTmpPersons(this.pService.getPerson(a.getId()));
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
