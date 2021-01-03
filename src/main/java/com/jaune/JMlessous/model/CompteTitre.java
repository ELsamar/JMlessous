package com.jaune.JMlessous.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="comptetitre")
public class CompteTitre {
	 @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private int  numCompte;
	@ManyToOne
	  private Client client;
	@OneToMany
	  private List<ProduitsDerives> produit;
	  private int nombre;
	public int getNumCompte() {
		return numCompte;
	}
	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public int getNombre() {
		return nombre;
	}
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public List<ProduitsDerives> getProduit() {
		return produit;
	}
	public void setProduit(List<ProduitsDerives> produit) {
		this.produit = produit;
	}
	

	  
}
