package com.jaune.JMlessous.model;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Client")

//@DiscriminatorValue("Client")
//public class Client extends Utilisateur{
public class Client extends Utilisateur{ 
	 @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private int  id;
private int age;


@OneToMany(mappedBy = "client")
private List<CompteCourant> CompteCourant;
@OneToMany(mappedBy = "client")
private List<CompteEpargne> compteEpargne;
 
@OneToMany(mappedBy = "client")
private List<CompteTitre> compteTitre;
 
@OneToMany(mappedBy = "client")
private List<Credit> credit;
 
@OneToMany(mappedBy = "client")
private List<Contrat> contrat;

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}
 


}
