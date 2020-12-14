package com.jaune.JMlessous.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import javax.persistence.Table;

@Entity
@Table(name="Produitassurance")
public class ProduitAssurance {
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private int id;
	  private String libelle;
		@ManyToMany
	  private List<AttributAssurance> attributs;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getLibelle() {
			return libelle;
		}
		public void setLibelle(String libelle) {
			this.libelle = libelle;
		}
		public List<AttributAssurance> getAttributs() {
			return attributs;
		}
		public void setAttributs(List<AttributAssurance> attributs) {
			this.attributs = attributs;
		}
	
}
