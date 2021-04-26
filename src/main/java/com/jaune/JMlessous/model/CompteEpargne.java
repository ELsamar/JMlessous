package com.jaune.JMlessous.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="compteepargne")

public class CompteEpargne {
	
	 @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int  id;
	 private int  RIB;
	 private int  plafond;
	 private float  solde;
    private Date dateOuverture;

	 @ManyToOne
	private Client client;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRIB() {
		return RIB;
	}

	public void setRIB(int rIB) {
		RIB = rIB;
	}

	public int getPlafond() {
		return plafond;
	}

	public void setPlafond(int plafond) {
		this.plafond = plafond;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public Date getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	 
}
