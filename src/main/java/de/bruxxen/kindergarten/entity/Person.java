package de.bruxxen.kindergarten.entity;

import java.util.ArrayList;

public class Person {
	private int id;
	private String lastName, firstName, mail;
	private ArrayList<Adress> adresses;
	private ArrayList<PhoneNumber> phoneNumbers;
	private ArrayList<Relation> relations;
	
	public Person() {
	}
	public Person(int id, String firstName, String lastName) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public ArrayList<Adress> getAdresses() {
		return adresses;
	}
	public void setAdresses(ArrayList<Adress> adresses) {
		this.adresses = adresses;
	}
	public ArrayList<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(ArrayList<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	public ArrayList<Relation> getRelations() {
		return relations;
	}
	public void setRelations(ArrayList<Relation> relations) {
		this.relations = relations;
	}

	

}
