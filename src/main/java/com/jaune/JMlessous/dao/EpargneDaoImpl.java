package com.jaune.JMlessous.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


import com.jaune.JMlessous.exception.ResourceNotFoundException;
import com.jaune.JMlessous.model.CompteEpargne;
import com.jaune.JMlessous.repository.EpargneRepository;


@Repository
public class EpargneDaoImpl {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	NamedParameterJdbcTemplate template;
	@Autowired
	private EpargneRepository epargneRepository;
	
	  public ResponseEntity<CompteEpargne> getCompteEpargneById(int CompteEpargneId)
		        throws ResourceNotFoundException {
		  CompteEpargne compteEpargneId = epargneRepository.findById(CompteEpargneId)
		          .orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + CompteEpargneId));
		        return ResponseEntity.ok().body(compteEpargneId);
		    }
	  
	  
	  public List<CompteEpargne> getAllCompteEpargne() {
	        return epargneRepository.findAll();
	    }
	
	
	  public CompteEpargne createCompteEpargne( CompteEpargne compteEpargne) {
	        return epargneRepository.save(compteEpargne);
	    }

	   public Map<String, Boolean> deleteCompteCourant(int compteCourantId)
		         throws ResourceNotFoundException {
		    	CompteCourant compteCourant= epargneRepository.findById(compteCourantId)
		       .orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + compteCourantId));

		    	epargneRepository.delete(compteCourant);
		        Map<String, Boolean> response = new HashMap<>();
		        response.put("deleted", Boolean.TRUE);
		        return response;
		    }
	
	
	   
	    public ResponseEntity<CompteEpargne> updateCompteEpargne(int CompteEpargneId, CompteEpargne ccDetails) throws ResourceNotFoundException {
	    	CompteEpargne compteEpargne = EpargneRepository.findById(CompteEpargneId)
	        .orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + CompteEpargneId));

	    	compteEpargne.setDateOuverture(ccDetails.getDateOuverture());
	    	compteEpargne.setRIB(ccDetails.getRIB());
	    	compteEpargne.setPlafond(ccDetails.getPlafond());
	    	compteEpargne.setSolde(ccDetails.getSolde());
	        final CompteEpargne updateCompteEpargne = EpargneRepository.save(compteEpargne);
	        return ResponseEntity.ok(updateCompteEpargne);
	    }
	   
	    
	  
	   
	/****************************************/
	
		 
		    
	
		
	


	
	
		
		
}
