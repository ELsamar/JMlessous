package com.jaune.JMlessous.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="carte")
public class Carte {
	 @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private int  id;
	 
	@ManyToOne

	private CompteCourant compteCourant;
}
