package de.bruxxen.kindergarten;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import de.bruxxen.kindergarten.data.DBAdresses;
import de.bruxxen.kindergarten.entity.Adress;

@Named
@SessionScoped
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private int tmpID = 1;
	
	public int getTmpID() {
		return tmpID;
	}
	public void setTmpID(int tmpID) {
		this.tmpID = tmpID;
	}
	
	
	
	
}
