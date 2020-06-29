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
	private String redirect = "";
	private int tmpID = 0;
	
	public String getRedirect() {
		return redirect;
	}
	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}
	public int getTmpID() {
		return tmpID;
	}
	public void setTmpID(int tmpID) {
		this.tmpID = tmpID;
	}
	
	
	
	
}
