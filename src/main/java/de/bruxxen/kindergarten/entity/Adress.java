package de.bruxxen.kindergarten.entity;

public class Adress {
	private String street, city, addition;
	private int plz, id, personId;
	
	public Adress() {
		this.street = "";
		this.plz = 0;
		this.city = "";
		this.addition = "";
	}
	public Adress(String street, int plz, String city) {
		this.street = street;
		this.plz = plz;
		this.city = city;
	}
	public Adress(int id, String street, int plz, String city) {
		this.street = street;
		this.plz = plz;
		this.city = city;
		this.id = id;
	}
	public Adress(String street, int plz, String city, String addition) {
		this.street = street;
		this.plz = plz;
		this.city = city;
		this.addition = addition;
	}
	public Adress(int id, String street, int plz, String city, String addition) {
		this.street = street;
		this.plz = plz;
		this.city = city;
		this.addition = addition;
		this.id = id;
		
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddition() {
		return addition;
	}
	public void setAddition(String addition) {
		this.addition = addition;
	}
	public int getPlz() {
		return plz;
	}
	public void setPlz(int plz) {
		this.plz = plz;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
}
