package de.bruxxen.kindergarten.service;

import java.io.Serializable;

import javax.faces.flow.FlowScoped;
import javax.inject.Named;

@Named
@FlowScoped(value="flow1")
public class Flow1Service implements Serializable{
	private String flowString = "Ich kann den flow spüren!";

	public String getFlowString() {
		return flowString;
	}

	public void setFlowString(String flowString) {
		this.flowString = flowString;
	}

}
