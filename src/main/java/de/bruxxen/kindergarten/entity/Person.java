package de.bruxxen.kindergarten.entity;

import java.util.ArrayList;

public class Person {
	private int id;
	private String lastName, firstName, mail;
	private Adress adress;
	private ArrayList<Integer> phoneNumbers;
	private ArrayList<Relation> relations;
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
	public Adress getAdress() {
		return adress;
	}
	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	public ArrayList<Integer> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(ArrayList<Integer> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	public ArrayList<Relation> getRelations() {
		return relations;
	}
	public void setRelations(ArrayList<Relation> relations) {
		this.relations = relations;
	}
	

}
