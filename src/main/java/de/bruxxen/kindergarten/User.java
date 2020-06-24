package de.bruxxen.kindergarten;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import de.bruxxen.kindergarten.data.DBAdresses;
import de.bruxxen.kindergarten.entity.Adress;

@Named
@SessionScoped
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private Adress adresse = new Adress("T", 1, "T");
	private DBAdresses dbAdresses = new DBAdresses();


	public Adress getAdresse() {
		this.adresse = this.dbAdresses.getAdress(1);
		if(this.adresse == null) {
			
			return new Adress("Jabai", 12998, "Bruizze");
		}else {	return adresse;}
	}

	public void setAdresse(Adress adresse) {
		this.adresse = adresse;
	}
	
	
	
	
}
