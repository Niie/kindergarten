package de.bruxxen.kindergarten.entity;

public class PhoneNumber {
	private int id, id_person;
	String phoneNumber;
	public PhoneNumber() {
		
	}
	public PhoneNumber(int id, String phoneNumber, int id_person) {
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.id_person = id_person;
	}
	public PhoneNumber(int id_person) {
		this.id_person = id_person;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getId_person() {
		return id_person;
	}

	public void setId_person(int id_person) {
		this.id_person = id_person;
	}

}
