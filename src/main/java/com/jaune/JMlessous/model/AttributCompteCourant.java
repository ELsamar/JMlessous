package com.jaune.JMlessous.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="attributcourantcategorie")
public class AttributCompteCourant {
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private int id;
	  private String libelle;
	  @Enumerated(EnumType.STRING)
	  private Typeatt type;
	  public String getValeur() {
		return valeur;
	}
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	private String valeur;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Typeatt getType() {
		return type;
	}
	public void setType(Typeatt type) {
		this.type = type;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	  
}
