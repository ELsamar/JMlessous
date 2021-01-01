package com.jaune.JMlessous.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

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
	
	
	
	
	
	/*********************/
	 public CompteEpargne() {
			super();
		}
	 public CompteEpargne(Client Client, Date dateOuverture,int RIB,int plafond,float solde) {
			super();
			this.Client = Client;
			this.RIB = RIB;
			this.dateOuverture = dateOuverture;
			this.plafond = plafond;
			this.solde=solde;
		}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRIB() {
		return RIB;
	}
	public void setRIB(int RIB) {
		this.RIB = RIB;
	}
	public float getSolde() {
		return solde;
	}
	public void setSolde(float solde) {
		this.solde = solde;
	}
	public int getPlafond() {
		return plafond;
	}
	public void setPlafond(int plafond) {
		this.plafond = plafond;
	}
	public Date getDateOuverture() {
		return dateOuverture;
	}
	public void setDateOuverture (Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}
}
