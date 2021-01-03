package com.jaune.JMlessous.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="comptecourantcategorie")
public class CompteCourantCategorie {
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private int id;
	  private String libelle;
		@ManyToMany
	  private List<AttributCompteCourant> attributs;
		
		
		@JsonIgnore
		@OneToMany( mappedBy = "categorie")
		
		private List<CompteCourant> ComptesCourant;
		
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
		public List<AttributCompteCourant> getAttributs() {
			return attributs;
		}
		public void setAttributs(List<AttributCompteCourant> attributs) {
			this.attributs = attributs;
		}
		
		public void setComptesCourant(List<CompteCourant> comptesCourant) {
			ComptesCourant = comptesCourant;
		}
		
	
}
