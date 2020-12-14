package com.jaune.JMlessous.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="comptecourant")
public class CompteCourant {
	 
	 @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private int  id;
		
	@ManyToOne	
	private Client client;
	
	@OneToMany(mappedBy = "compteCourant")
	private List<Carte> carte;
	@OneToMany(mappedBy = "compteCourant")
	private List<CarnetCheque > carnetCheque ;
}
