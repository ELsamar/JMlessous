package com.jaune.JMlessous.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jaune.JMlessous.exception.ResourceNotFoundException;

import com.jaune.JMlessous.model.AttributCompteCourant;
import com.jaune.JMlessous.model.CompteCourantCategorie;

import com.jaune.JMlessous.repository.AttributCompteCourantRepository;
import com.jaune.JMlessous.repository.CompteCourantCategorieRepository;



@Repository
public class CompteCourantCategorieDaoImpl {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	NamedParameterJdbcTemplate template;
	@Autowired
	private CompteCourantCategorieRepository compteCourantCategorieRepository;
	@Autowired
	private AttributCompteCourantRepository attributCompteCourantRepository;
	
	
	public ResponseEntity<CompteCourantCategorie> affecterAttributCpt(int attrId, int cptId) throws ResourceNotFoundException {

		
		AttributCompteCourant att = attributCompteCourantRepository.findById(attrId) 
				.orElseThrow(() -> new ResourceNotFoundException("attr not found for this id :: " + attrId));
		CompteCourantCategorie cpt = compteCourantCategorieRepository.findById(cptId)
				.orElseThrow(() -> new ResourceNotFoundException("CompteCourantCategorie not found for this id :: " + cptId));
		
			if(cpt.getAttributs() == null){
				List<AttributCompteCourant> attributs = new ArrayList<>();
				attributs.add(att);
				cpt.setAttributs(attributs);
			}else{
				cpt.getAttributs().add(att);
			}
			
			 final CompteCourantCategorie updatecpt= compteCourantCategorieRepository.save(cpt);
		        return ResponseEntity.ok(updatecpt);
		
	}
	
	public List<CompteCourantCategorie> getAllCpt() {
        return compteCourantCategorieRepository.findAll();
    }


    public ResponseEntity<CompteCourantCategorie> getCptById(int cptId)
        throws ResourceNotFoundException {
    	CompteCourantCategorie cpt = compteCourantCategorieRepository.findById(cptId)
          .orElseThrow(() -> new ResourceNotFoundException("CompteCourantCategorie not found for this id :: " + cptId));
        return ResponseEntity.ok().body(cpt);
    }
    

    public CompteCourantCategorie createCpt( CompteCourantCategorie cpt) {
        return compteCourantCategorieRepository.save(cpt);
    } 


    public ResponseEntity<CompteCourantCategorie> updateCpt(int cptId,
    		CompteCourantCategorie cptDetails) throws ResourceNotFoundException {
    	CompteCourantCategorie cpt = compteCourantCategorieRepository.findById(cptId)
        .orElseThrow(() -> new ResourceNotFoundException("CompteCourantCategorie not found for this id :: " + cptId));

    	cpt.setLibelle(cptDetails.getLibelle());
    	cpt.setAttributs((cptDetails.getAttributs()));
        final CompteCourantCategorie updatecpt= compteCourantCategorieRepository.save(cpt);
        return ResponseEntity.ok(updatecpt);
    }


    public Map<String, Boolean> deleteCpt(int cptId)
         throws ResourceNotFoundException {
    	CompteCourantCategorie cpt = compteCourantCategorieRepository.findById(cptId)
       .orElseThrow(() -> new ResourceNotFoundException("assurance not found for this id :: " + cptId));

    	compteCourantCategorieRepository.delete(cpt);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
