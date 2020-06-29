package de.bruxxen.kindergarten.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.bruxxen.kindergarten.User;
import de.bruxxen.kindergarten.entity.Adress;
import de.bruxxen.kindergarten.entity.PhoneNumber;

@Named
@RequestScoped
public class ListPhoneNumberService {
	@Inject
	User user;
	@Inject
	PhoneNumberService pnService;
	ListPersonenService lpService = new ListPersonenService();

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
	public void toEditPerson(int id) {
		this.lpService.navEditPerson(id);
	}
}
