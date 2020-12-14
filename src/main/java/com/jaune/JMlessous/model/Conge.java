package com.jaune.JMlessous.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="conge")
public class Conge {
	 @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private int  id;
	 @ManyToOne	(cascade = CascadeType.MERGE )
	 private Employe employe;
	 private Date datedebut;
	 private Date datefin;
	 private String statut;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public Date getDatedebut() {
		return datedebut;
	}
	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}
	public Date getDatefin() {
		return datefin;
	}
	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	
	public Conge() {
		super();
	}
	public Conge(Employe employe, Date datedebut, Date datefin, String statut) {
		super();
		this.employe = employe;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.statut = statut;
	}
	@Override
	public String toString() {
		return "Conge [id=" + id + ", employe=" + employe + ", datedebut=" + datedebut + ", datefin=" + datefin
				+ ", statut=" + statut + "]";
	}
	 
}
