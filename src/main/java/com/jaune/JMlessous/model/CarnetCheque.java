package com.jaune.JMlessous.model;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="carnetcheque")
public class CarnetCheque {
	 @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private int  id;
	 private int nb;
	 private Date datelivre;
	 private Date datedemande ;
	 private Boolean barre;
	 private String statut;
	
	 @JsonIgnore
	 @ManyToOne
		private CompteCourant compteCourant;
	 
	 
	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "carnetcheque")
	
	 private List<Cheque> Cheques;


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public int getNb() {
			return nb;
		}


		public void setNb(int nb) {
			this.nb = nb;
		}


		public Date getDatelivre() {
			return datelivre;
		}


		public void setDatelivre(Date datelivre) {
			this.datelivre = datelivre;
		}


		public Date getDatedemande() {
			return datedemande;
		}


		public void setDatedemande(Date datedemande) {
			this.datedemande = datedemande;
		}


		public Boolean getBarre() {
			return barre;
		}


		public void setBarre(Boolean barre) {
			this.barre = barre;
		}


		public String getStatut() {
			return statut;
		}


		public void setStatut(String statut) {
			this.statut = statut;
		}


		public CompteCourant getCompteCourant() {
			return compteCourant;
		}


		public void setCompteCourant(CompteCourant compteCourant) {
			this.compteCourant = compteCourant;
		}


		public List<Cheque> getCheques() {
			return Cheques;
		}


		public void setCheques(List<Cheque> cheques) {
			Cheques = cheques;
		}

}
