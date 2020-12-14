package com.jaune.JMlessous.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Employe")

//@DiscriminatorValue("Employe")
public class Employe extends Utilisateur {

	private float salaire ; 
	@Enumerated(EnumType.STRING)
	private EmployeFonction fonction;
	@ManyToMany(mappedBy = "employes")
    private List<Formation> formation;
	@OneToMany(mappedBy = "employe")
	private List<Conge> Conge;

	public float getSalaire() {
		return salaire;
	}
	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}
	public List<Formation> getFormation() {
		return formation;
	}
	public void setFormation(List<Formation> formation) {
		this.formation = formation;
	}
	public EmployeFonction getFonction() {
		return fonction;
	}
	public void setFonction(EmployeFonction fonction) {
		this.fonction = fonction;
	}

	
}
