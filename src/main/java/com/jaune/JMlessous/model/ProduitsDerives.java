package com.jaune.JMlessous.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProduitsDerives {
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private int id;
	  private int nombre;
	  private String Entreprise;
	  private Date echeance;
	  private Date dateTransaction;
	  @Enumerated(EnumType.STRING)
	  private typeProduitsDerivees type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNombre() {
		return nombre;
	}
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	public String getEntreprise() {
		return Entreprise;
	}
	public void setEntreprise(String entreprise) {
		Entreprise = entreprise;
	}
	public Date getEcheance() {
		return echeance;
	}
	public void setEcheance(Date echeance) {
		this.echeance = echeance;
	}
	public typeProduitsDerivees getType() {
		return type;
	}
	public void setType(typeProduitsDerivees type) {
		this.type = type;
	}
	public Date getDateTransaction() {
		return dateTransaction;
	}
	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}
	 
}
