package de.bruxxen.kindergarten.service;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.bruxxen.kindergarten.User;
import de.bruxxen.kindergarten.data.DBPhoneNumbers;
import de.bruxxen.kindergarten.entity.PhoneNumber;

@Named
@SessionScoped
public class PhoneNumberService implements Serializable {
	private static final long serialVersionUID = 1L;
	private DBPhoneNumbers DBPhoneNumbers = new DBPhoneNumbers();
	private ArrayList<PhoneNumber> tmpPhoneNumbers = new ArrayList<PhoneNumber>();
	private PhoneNumber emptyPhoneNumber = new PhoneNumber();
	@Inject
	private User user;

	public PhoneNumberService() {
		try {
			this.tmpPhoneNumbers = this.DBPhoneNumbers.getPhoneNumber();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<PhoneNumber> gettmpPhoneNumbers() {
		return tmpPhoneNumbers;
	}
	public void setTmpPhoneNumbers(ArrayList<PhoneNumber> tmpPhoneNumbers) {
		this.tmpPhoneNumbers = tmpPhoneNumbers;
	}
	public PhoneNumber getemptyPhoneNumber() {
		return emptyPhoneNumber;
	}
	public void setemptyPhoneNumber(PhoneNumber emptyPhoneNumber) {
		this.emptyPhoneNumber = emptyPhoneNumber;
	}
	public ArrayList<PhoneNumber> getPhoneNumber(int id) {
		try {
			this.tmpPhoneNumbers = this.DBPhoneNumbers.getPhoneNumber(id); 
			return this.tmpPhoneNumbers;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<PhoneNumber> getPhoneNumber() {
		try {
			this.tmpPhoneNumbers = this.DBPhoneNumbers.getPhoneNumber(); 
			return this.tmpPhoneNumbers;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void updatePhoneNumber(PhoneNumber a) {
		try {
			this.DBPhoneNumbers.updatePhoneNumber(a);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	public String updatePhoneNumber(PhoneNumber a, String nav) {
		try {
			this.DBPhoneNumbers.updatePhoneNumber(a);
			this.tmpPhoneNumbers = this.DBPhoneNumbers.getPhoneNumber();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return nav;
	}
	public void insertPhoneNumber(PhoneNumber a) {
		try {
			this.DBPhoneNumbers.insertPhoneNumber(a);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	public void deletePhoneNumber(PhoneNumber a) {
		this.DBPhoneNumbers.deletePhoneNumber(a);	
	}
}
