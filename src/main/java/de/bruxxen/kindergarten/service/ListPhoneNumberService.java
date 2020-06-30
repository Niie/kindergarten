package de.bruxxen.kindergarten.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.bruxxen.kindergarten.entity.User;
import de.bruxxen.kindergarten.entity.Adress;
import de.bruxxen.kindergarten.entity.PhoneNumber;

@Named
@RequestScoped
public class ListPhoneNumberService {
	@Inject
	User user;
	@Inject
	PhoneNumberService pnService;
	@Inject
	ListPersonenService lpService;

	public String navEditPhoneNumber(PhoneNumber pn) {
		this.pnService.setTmpPhoneNumbers(this.pnService.getPhoneNumber(pn.getId()));
		return "editPhoneNumber.xhtml";	
	}
	public String navListPhoneNumber() {
		this.pnService.setTmpPhoneNumbers(this.pnService.getPhoneNumber());
		return "listPhoneNumber.xhtml";	
	}
	public String navNewPhoneNumber() {
		return "insertPhoneNumber.xhtml";	
	}
	public String toEditPerson(int id) {
		return this.lpService.navEditPerson(id);
	}
}
