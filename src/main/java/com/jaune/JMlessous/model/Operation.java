package com.jaune.JMlessous.model;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Operation {
	 @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private int  id;
	  private  Date datevaleur;
	  private String libele;
	  private String reference;
	  private Date dateoperation;
	  private float montant;
	  private String statut;
	  private String devise;
	  private Float taux ;
	  private Boolean interBank;
	 
	 @ManyToOne
		private CompteCourant comptecourant;
	 @ManyToOne
		private CompteCourant comptecourantdestinataire;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatevaleur() {
		return datevaleur;
	}

	public void setDatevaleur(Date datevaleur) {
		this.datevaleur = datevaleur;
	}

	public String getLibele() {
		return libele;
	}

	public void setLibele(String libele) {
		this.libele = libele;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Date getDateoperation() {
		return dateoperation;
	}

	public void setDateoperation(Date dateoperation) {
		this.dateoperation = dateoperation;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Float getTaux() {
		return taux;
	}

	public void setTaux(Float taux) {
		this.taux = taux;
	}

	public CompteCourant getComptecourant() {
		return comptecourant;
	}

	public void setComptecourant(CompteCourant comptecourant) {
		this.comptecourant = comptecourant;
	}

	public CompteCourant getComptecourantdestinataire() {
		return comptecourantdestinataire;
	}

	public void setComptecourantdestinataire(CompteCourant comptecourantdestinataire) {
		this.comptecourantdestinataire = comptecourantdestinataire;
	}

	public String getDevise() {
		return devise;
	}

	public void setDevise(String devise) {
		this.devise = devise;
	}

	public Boolean getInterBank() {
		return interBank;
	}

	public void setInterBank(Boolean interBank) {
		this.interBank = interBank;
	}

	@Override
	public String toString() {
		return "Operation [id=" + id + ", datevaleur=" + datevaleur + ", libele=" + libele + ", reference=" + reference
				+ ", dateoperation=" + dateoperation + ", montant=" + montant + ", statut=" + statut + ", devise="
				+ devise + ", taux=" + taux + ", interBank=" + interBank + ", comptecourant=" + comptecourant
				+ ", comptecourantdestinataire=" + comptecourantdestinataire + "]";
	}

	 

}
