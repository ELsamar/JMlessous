package com.jaune.JMlessous.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Repository;




import com.jaune.JMlessous.exception.ResourceNotFoundException;
import com.jaune.JMlessous.model.CompteCourant;

import com.jaune.JMlessous.repository.CompteCourantRepository;

@Repository
public class CompteCourantDaoIml {
	
			@Autowired
		private CompteCourantRepository compteCourantRepository;
			

				
		public CompteCourant createCpt( CompteCourant CompteCourant) {
			CompteCourant.setRip((int)(Math.random() * 9000) + 1000);
		 
			CompteCourant.setDateOuverture(new Date());
			        return compteCourantRepository.save(CompteCourant);
			    } 
		public List<CompteCourant> getAllCpt() {
	        return compteCourantRepository.findAll();
	    }
		  public ResponseEntity<CompteCourant> getcptById(int cptID)
			        throws ResourceNotFoundException {
			 CompteCourant compteCourant = compteCourantRepository.findById( cptID)
					 .orElse(null);
					 //   .orElseThrow(() -> new ResourceNotFoundException("CompteCourant not found for this id :: " + cptID));
			        return ResponseEntity.ok().body(compteCourant);
			    }
		  public ResponseEntity<CompteCourant> updateCpt(int cptId,
				  CompteCourant compteCourantDetails) throws ResourceNotFoundException {
			  CompteCourant compteCourant = compteCourantRepository.findById(cptId)
		        .orElseThrow(() -> new ResourceNotFoundException("assurance not found for this id :: " + cptId));

			  compteCourant.setCategorie(compteCourantDetails.getCategorie());
			  compteCourant.setDateFermeture(compteCourantDetails.getDateFermeture());
			  compteCourant.setDateOuverture(compteCourantDetails.getDateOuverture());
			  compteCourant.setDevise(compteCourantDetails.getDevise());
			  compteCourant.setSolde(compteCourantDetails.getSolde());
		        final CompteCourant updatecompteCourant= compteCourantRepository.save(compteCourant);
		        return ResponseEntity.ok(updatecompteCourant);
		    }


		    public Map<String, Boolean> deleteCpt(int cptId)
		         throws ResourceNotFoundException {
		    	CompteCourant compteCourant = compteCourantRepository.findById(cptId)
		       .orElseThrow(() -> new ResourceNotFoundException("compteCourant not found for this id :: " + cptId));

		    	compteCourantRepository.delete(compteCourant);
		        Map<String, Boolean> response = new HashMap<>();
		        response.put("deleted", Boolean.TRUE);
		        return response;
		    }
			public List<CompteCourant> getcptByClient(int userID) {
				return compteCourantRepository.findCptByClient(userID);
			}
			public CompteCourant getcptByrip(int rip) {
				// TODO Auto-generated method stub
				return compteCourantRepository.findCptByRip(rip);
			}

}
