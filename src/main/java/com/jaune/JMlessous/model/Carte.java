package com.jaune.JMlessous.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="carte")
public class Carte {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int  id;
	private int  numeroCarte;
	private Float plafond;
	private int CodeSecret;
	private Date dateExpiration;
	private String statut;
	private Float montant;	
	private String libelle;
	private Boolean prepayee;
	
	@ManyToOne	(cascade = CascadeType.MERGE )
	@JsonIgnore
	private CompteCourant compteCourant;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroCarte() {
		return numeroCarte;
	}

	public void setNumeroCarte(int numeroCarte) {
		this.numeroCarte = numeroCarte;
	}

	public Float getPlafond() {
		return plafond;
	}

	public void setPlafond(Float plafond) {
		this.plafond = plafond;
	}

	public int getCodeSecret() {
		return CodeSecret;
	}

	public void setCodeSecret(int codeSecret) {
		CodeSecret = codeSecret;
	}

	public Date getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public CompteCourant getCompteCourant() {
		return compteCourant;
	}

	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}
	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Float getMontant() {
		return montant;
	}

	public void setMontant(Float montant) {
		this.montant = montant;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Boolean getPrepayee() {
		return prepayee;
	}

	public void setPrepayee(Boolean prepayee) {
		this.prepayee = prepayee;
	}
	
}
