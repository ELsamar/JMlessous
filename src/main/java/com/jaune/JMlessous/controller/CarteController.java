package com.jaune.JMlessous.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaune.JMlessous.dao.CarteDaoImpl;

import com.jaune.JMlessous.exception.ResourceNotFoundException;
import com.jaune.JMlessous.model.Carte;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/carte")
public class CarteController {
	
	
	 @Autowired
	 CarteDaoImpl carteDaoImpl;	


	   @PutMapping("/traiteStatut/{id}")
	    public ResponseEntity<Carte> traiteStatut(@PathVariable(value = "id") int carteId,
	         @Validated @RequestBody String statut) throws ResourceNotFoundException {	    
	        return carteDaoImpl.traiteStatut(carteId, statut);
	    }
	   
	   @PutMapping("/renouvelle/{id}")
	    public ResponseEntity<Carte> renouvelleCarte(@PathVariable(value = "id") int carteId,
	         @Validated @RequestBody float montant) throws ResourceNotFoundException {
	        return carteDaoImpl.renouvelleCarte(carteId, montant);
	    }
	   
	   
	 @GetMapping("/all")
	    public List<Carte> getAllCarte() {
	        return carteDaoImpl.getAllCarte();
	    }
	
	    @GetMapping("/{id}")
	    public ResponseEntity<Carte> getCarteById(@PathVariable(value = "id") int carteId)
	        throws ResourceNotFoundException {	    	
	        return carteDaoImpl.getCarteById(carteId);
	    }
	    
	    @PostMapping("/add/{id}")
	    public Carte createCarte(@Validated @RequestBody Carte carte,@PathVariable(value = "id") int id) throws ResourceNotFoundException {
	        return carteDaoImpl.createCarte(carte,id);
	    }

	    @PutMapping("/update/{id}")
	    public ResponseEntity<Carte> updateCarte(@PathVariable(value = "id") int CarteId,
	         @Validated @RequestBody Carte CarteDetails) throws ResourceNotFoundException {
	        return carteDaoImpl.updateCarte(CarteId, CarteDetails);
	    }

	    @DeleteMapping("/del/{id}")
	    public Map<String, Boolean> deleteCarte(@PathVariable(value = "id") int carteId)
	         throws ResourceNotFoundException {	    	
	        return carteDaoImpl.deleteCarte(carteId);
	    }
	}


