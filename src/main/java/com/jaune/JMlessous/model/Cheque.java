package com.jaune.JMlessous.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cheque")
public class Cheque {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int  id;
	 private int numero;
	 private Date dateRemise;
	 
	 @ManyToOne
	 private CarnetCheque carnetcheque;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getDateRemise() {
		return dateRemise;
	}

	public void setDateRemise(Date dateRemise) {
		this.dateRemise = dateRemise;
	}
	 
}
