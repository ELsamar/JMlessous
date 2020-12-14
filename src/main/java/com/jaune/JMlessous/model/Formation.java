package com.jaune.JMlessous.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="formation")
public class Formation {
	 @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private int  id;
	@ManyToMany(cascade = CascadeType.ALL)
  
    private List<Employe> employes;
}
