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
import com.jaune.JMlessous.model.Conge;
import com.jaune.JMlessous.repository.CongeRepository;
@Repository
public class CongeDaoImpl {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	NamedParameterJdbcTemplate template;
	@Autowired
	private CongeRepository congeRepository;
	

	    public ResponseEntity<Conge> traiteConge( int congeId,String statut) throws ResourceNotFoundException {
	    	Conge conge = congeRepository.findById(congeId)
	        .orElseThrow(() -> new ResourceNotFoundException("Conge not found for this id :: " + congeId));
	    	System.out.println(conge);
	    	conge.setStatut(statut);
	        final Conge updateconge = congeRepository.save(conge);
	        System.out.println(updateconge);
	        return ResponseEntity.ok(updateconge);
	    }

		    public List<Conge> getAllConge() {
		        return congeRepository.findAll();
		    }
		
	
		    public ResponseEntity<Conge> getCongeById(int congeId)
		        throws ResourceNotFoundException {
		    	Conge conge = congeRepository.findById(congeId)
		          .orElseThrow(() -> new ResourceNotFoundException("Conge not found for this id :: " + congeId));
		        return ResponseEntity.ok().body(conge);
		    }
		    
	
		    public Conge createConge( Conge conge) {
		        return congeRepository.save(conge);
		    } 


		    public ResponseEntity<Conge> updateConge(int congeId,
		        Conge congeDetails) throws ResourceNotFoundException {
		    	Conge conge = congeRepository.findById(congeId)
		        .orElseThrow(() -> new ResourceNotFoundException("Conge not found for this id :: " + congeId));

		    	conge.setDatedebut(congeDetails.getDatedebut());
		    	conge.setDatefin(congeDetails.getDatefin());
		    	conge.setStatut(congeDetails.getStatut());
		        final Conge updateconge = congeRepository.save(conge);
		        return ResponseEntity.ok(updateconge);
		    }

	
		    public Map<String, Boolean> deleteConge(int congeId)
		         throws ResourceNotFoundException {
		    	Conge conge = congeRepository.findById(congeId)
		       .orElseThrow(() -> new ResourceNotFoundException("Conge not found for this id :: " + congeId));

		    	congeRepository.delete(conge);
		        Map<String, Boolean> response = new HashMap<>();
		        response.put("deleted", Boolean.TRUE);
		        return response;
		    }
		
}
