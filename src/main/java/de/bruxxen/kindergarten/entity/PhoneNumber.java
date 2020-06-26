package de.bruxxen.kindergarten.entity;

public class PhoneNumber {
	private int id, phoneNumber, id_person;
	
	public PhoneNumber(int id, int phoneNumber, int id_person) {
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.id_person = id_person;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getId_person() {
		return id_person;
	}

	public void setId_person(int id_person) {
		this.id_person = id_person;
	}

}
