package com.jaune.JMlessous.dao;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jaune.JMlessous.exception.ResourceNotFoundException;

import com.jaune.JMlessous.model.Carte;
import com.jaune.JMlessous.model.CompteCourant;

import com.jaune.JMlessous.repository.CarteRepository;
import com.jaune.JMlessous.repository.CompteCourantRepository;



@Repository
public class CarteDaoImpl {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	NamedParameterJdbcTemplate template;
	@Autowired
	private CarteRepository carteRepository;
	@Autowired
	private CompteCourantRepository compteCourantRepository;
	
    public ResponseEntity<Carte> traiteStatut( int carteId,String statut) throws ResourceNotFoundException {
    	Carte carte = carteRepository.findById(carteId)
        .orElseThrow(() -> new ResourceNotFoundException("Carte not found for this id :: " + carteId));
    	 carte.setStatut(statut);
        final Carte updatecarte = carteRepository.save(carte);
        return ResponseEntity.ok(updatecarte);
    }
	  @SuppressWarnings("deprecation")
	public ResponseEntity<Carte> renouvelleCarte(int carteId, float montant) throws ResourceNotFoundException {
	    	Carte carte = carteRepository.findById(carteId)
	        .orElseThrow(() -> new ResourceNotFoundException("Carte not found for this id :: " + carteId));
	    	//Date d = new Date();
	    	Date d = carte.getDateExpiration();
	    	d.setYear(d.getYear()+1);
	    	carte.setDateExpiration(d);
	    	carte.setMontant(carte.getMontant()-montant);
	    	carte.setStatut("renouvelée");
	        final Carte updatedcarte = carteRepository.save(carte);
	        return ResponseEntity.ok(updatedcarte);
	    }

	    public List<Carte> getAllCarte() {
	        return carteRepository.findAll();
	    }
	

	    public ResponseEntity<Carte> getCarteById(int carteId)
	        throws ResourceNotFoundException {
	    	Carte client = carteRepository.findById(carteId)
	          .orElseThrow(() -> new ResourceNotFoundException("carte not found for this id :: " + carteId));
	        return ResponseEntity.ok().body(client);
	    }
	    
	 
	    public Carte createCarte( Carte carte,int id) throws ResourceNotFoundException{
	    	CompteCourant c =compteCourantRepository.findById(id)
	    			.orElseThrow(() -> new ResourceNotFoundException("CompteCourant not found for this id :: " + id));
	    	carte.setCompteCourant(c);
	    	Date d = new Date();
	    	d.setYear(d.getYear()+1);
	    	carte.setDateExpiration(d);
	    	carte.setNumeroCarte((int)(Math.random() * 9000) + 1000);
	    	return carteRepository.save(carte);
			
	    }

	
	    public ResponseEntity<Carte> updateCarte(int carteId, Carte carteDetails) throws ResourceNotFoundException {
	    	Carte carte = carteRepository.findById(carteId)
	        .orElseThrow(() -> new ResourceNotFoundException("Carte not found for this id :: " + carteId));

	    	carte.setCodeSecret(carteDetails.getCodeSecret());
	    	carte.setDateExpiration(carteDetails.getDateExpiration());
	    	carte.setCodeSecret(carteDetails.getCodeSecret());
	    	carte.setPlafond(carteDetails.getPlafond());
	    	carte.setStatut(carteDetails.getStatut());
	    	carte.setNumeroCarte(carteDetails.getNumeroCarte());
	    	carte.setMontant(carteDetails.getMontant());
	    	carte.setLibelle(carteDetails.getLibelle());
	    	carte.setPrepayee(carteDetails.getPrepayee());
	        final Carte updatedcarte = carteRepository.save(carte);
	        return ResponseEntity.ok(updatedcarte);
	    }

	 
	    public Map<String, Boolean> deleteCarte(int carteId)
	         throws ResourceNotFoundException {
	    	Carte carte= carteRepository.findById(carteId)
	       .orElseThrow(() -> new ResourceNotFoundException("carte not found for this id :: " + carteId));

	    	carteRepository.delete(carte);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
}
