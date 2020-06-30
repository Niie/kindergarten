package de.bruxxen.kindergarten.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.bruxxen.kindergarten.entity.User;
import de.bruxxen.kindergarten.entity.Adress;

@Named
@RequestScoped
public class ListAdressenService {
	@Inject
	User user;
	@Inject
	AdressenService aService;

	public String navEditAdress(Adress a) {
		this.aService.setTmpAdresses(this.aService.getAdress(a.getId()));
		return "editAdresse.xhtml";	
	}
	public String navListAdresse() {
		this.aService.setTmpAdresses(this.aService.getAdress());
		return "listAdresse.xhtml";	
	}
	public String navNewAdresse() {
		return "insertAdresse.xhtml";	
	}
}
