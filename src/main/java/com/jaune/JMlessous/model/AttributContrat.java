package com.jaune.JMlessous.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AttributContrat {
	@Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private int id;
	  public AttributContrat() {
		super();
	}
	public AttributContrat(String attribut) {
		super();
		this.attribut = attribut;
	}
	public AttributContrat(int id, String attribut) {
		super();
		this.id = id;
		this.attribut = attribut;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAttribut() {
		return attribut;
	}
	public void setAttribut(String attribut) {
		this.attribut = attribut;
	}
	private String attribut;
	
}
