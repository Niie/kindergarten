package de.bruxxen.kindergarten.entity;

public class Relation {
	private Person a, b;
	private String relationshipt;
	public Person getA() {
		return a;
	}
	public void setA(Person a) {
		this.a = a;
	}
	public Person getB() {
		return b;
	}
	public void setB(Person b) {
		this.b = b;
	}
	public String getRelationshipt() {
		return relationshipt;
	}
	public void setRelationshipt(String relationshipt) {
		this.relationshipt = relationshipt;
	}
}