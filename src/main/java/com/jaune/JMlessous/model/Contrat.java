package com.jaune.JMlessous.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
public class Contrat {
	 @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private int  id;
	  private String souscripteur;
	  private String assure;
	  private String beneficiaire ;
	  Date datedebut;
	  Date datefin;
	  private float montant;
	  private float prime;
	  private String AdresseSiegeSocialAssureur;
	  @Enumerated(EnumType.STRING)
	  private EtatPdAssurance etat;
	  
	  
	public Contrat(String souscripteur, String assure, String beneficiaire, Date datedebut, Date datefin, float montant,
			float prime, String adresseSiegeSocialAssureur, Client client, ProduitAssurance produitassurance) {
		
		this.souscripteur = souscripteur;
		this.assure = assure;
		this.beneficiaire = beneficiaire;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.montant = montant;
		this.prime = prime;
		AdresseSiegeSocialAssureur = adresseSiegeSocialAssureur;
		this.client = client;
		this.produitassurance = produitassurance;
	}
	public Contrat(String souscripteur) {
	
		this.souscripteur = souscripteur;
	}
	public Contrat(String souscripteur, String assure, String beneficiaire,Date datedebut,Date datefin, float montant, float prime,
			String adresseSiegeSocialAssureur) {
		
		this.souscripteur = souscripteur;
		this.assure = assure;
		this.beneficiaire = beneficiaire;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.montant = montant;
		this.prime = prime;
		AdresseSiegeSocialAssureur = adresseSiegeSocialAssureur;
	}
	public Contrat() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSouscripteur() {
		return souscripteur;
	}
	public void setSouscripteur(String souscripteur) {
		this.souscripteur = souscripteur;
	}
	public String getAssure() {
		return assure;
	}
	public void setAssure(String assure) {
		this.assure = assure;
	}
	public String getBeneficiaire() {
		return beneficiaire;
	}
	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
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
	public float getMontant() {
		return montant;
	}
	public void setMontant(float montant) {
		this.montant = montant;
	}
	public float getPrime() {
		return prime;
	}
	public void setPrime(float prime) {
		this.prime = prime;
	}
	public String getAdresseSiegeSocialAssureur() {
		return AdresseSiegeSocialAssureur;
	}
	public void setAdresseSiegeSocialAssureur(String adresseSiegeSocialAssureur) {
		AdresseSiegeSocialAssureur = adresseSiegeSocialAssureur;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public ProduitAssurance getProduitassurance() {
		return produitassurance;
	}
	public Contrat(String souscripteur, String assure, String beneficiaire, Date datedebut, Date datefin, float montant,
			float prime, String adresseSiegeSocialAssureur, ProduitAssurance produitassurance) {
		super();
		this.souscripteur = souscripteur;
		this.assure = assure;
		this.beneficiaire = beneficiaire;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.montant = montant;
		this.prime = prime;
		AdresseSiegeSocialAssureur = adresseSiegeSocialAssureur;
		this.produitassurance = produitassurance;
	}
	public void setProduitassurance(ProduitAssurance produitassurance) {
		this.produitassurance = produitassurance;
	}
	@ManyToOne
	private Client client;
	public Contrat(String souscripteur, String assure, String beneficiaire, Date datedebut, Date datefin, float montant,
			float prime, String adresseSiegeSocialAssureur, Client client, ProduitAssurance produitassurance,
			List<AttributContrat> attributsContrat) {
		super();
		this.souscripteur = souscripteur;
		this.assure = assure;
		this.beneficiaire = beneficiaire;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.montant = montant;
		this.prime = prime;
		AdresseSiegeSocialAssureur = adresseSiegeSocialAssureur;
		this.client = client;
		this.produitassurance = produitassurance;
		this.attributsContrat = attributsContrat;
	}
	@ManyToOne
	private ProduitAssurance produitassurance;
	public List<AttributContrat> getAttributsContrat() {
		return attributsContrat;
	}
	public void setAttributsContrat(List<AttributContrat> attributsContrat) {
		this.attributsContrat = attributsContrat;
	}
	@ManyToMany
	private List<AttributContrat> attributsContrat;


	
}
