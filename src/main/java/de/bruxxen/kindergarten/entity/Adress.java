package de.bruxxen.kindergarten.entity;

public class Adress {
	private String street, city, addition;
	private int plz;
	
	public Adress(String street, int plz, String city) {
		this.street = street;
		this.plz = plz;
		this.city = city;
	}
	public Adress(String street, int plz, String city, String addition) {
		this.street = street;
		this.plz = plz;
		this.city = city;
		this.addition = addition;
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
}
