package de.bruxxen.kindergarten.service;

import java.sql.SQLException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.bruxxen.kindergarten.User;
import de.bruxxen.kindergarten.data.DBAdresses;
import de.bruxxen.kindergarten.entity.Adress;

@Named
@RequestScoped
public class AdressenService {
	private DBAdresses dbAdressen = new DBAdresses();
	@Inject
	private User user;

	public Adress getAdress() {
		try {
			return this.dbAdressen.getAdress(this.user.getTmpID());
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
}
