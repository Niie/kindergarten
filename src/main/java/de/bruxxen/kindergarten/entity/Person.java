package de.bruxxen.kindergarten.entity;

import java.util.ArrayList;

public class Person {
	private String lastName, sureName, mail;
	private Adress adress;
	private int phoneNumber;
	private ArrayList<Relation> relations;
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSureName() {
		return sureName;
	}
	public void setSureName(String sureName) {
		this.sureName = sureName;
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
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public ArrayList<Relation> getRelations() {
		return relations;
	}
	public void setRelations(ArrayList<Relation> relations) {
		this.relations = relations;
	}

}
