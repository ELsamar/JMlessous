package com.jaune.JMlessous.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="comptecourant")
public class CompteCourant {
	 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int  id;
	
	private Float solde;
	private Date dateOuverture;
	private Date dateFermeture;
	private String devise;
	private int rip;
	
	@ManyToOne	
	private Client client;
	
	@OneToMany(mappedBy = "compteCourant")
	private List<Carte> carte;
	@OneToMany(mappedBy = "compteCourant")
	private List<CarnetCheque > carnetCheque ;
	@ManyToOne		
	private CompteCourantCategorie categorie;
	@OneToMany(mappedBy = "comptecourant")
	private List<Operation > Operations;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Float getSolde() {
		return solde;
	}
	public void setSolde(Float solde) {
		this.solde = solde;
	}
	public Date getDateOuverture() {
		return dateOuverture;
	}
	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}
	public Date getDateFermeture() {
		return dateFermeture;
	}
	public void setDateFermeture(Date dateFermeture) {
		this.dateFermeture = dateFermeture;
	}
	public String getDevise() {
		return devise;
	}
	public void setDevise(String devise) {
		this.devise = devise;
	}
	public int getRip() {
		return rip;
	}
	public void setRip(int rip) {
		this.rip = rip;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Carte> getCarte() {
		return carte;
	}
	public void setCarte(List<Carte> carte) {
		this.carte = carte;
	}
	public List<CarnetCheque> getCarnetCheque() {
		return carnetCheque;
	}
	public void setCarnetCheque(List<CarnetCheque> carnetCheque) {
		this.carnetCheque = carnetCheque;
	}
	public CompteCourantCategorie getCategorie() {
		return categorie;
	}
	public void setCategorie(CompteCourantCategorie categorie) {
		this.categorie = categorie;
	}
	
}
