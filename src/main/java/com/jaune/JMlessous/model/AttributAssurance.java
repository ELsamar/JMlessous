package com.jaune.JMlessous.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AttributAssurance {
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private int id;
	  private String libellè;
	  @Enumerated(EnumType.STRING)
	  private Typeatt type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libellè;
	}
	public void setLibelle(String libellè) {
		this.libellè = libellè;
	}
	public Typeatt getType() {
		return type;
	}
	public void setType(Typeatt type) {
		this.type = type;
	}
	  
}
