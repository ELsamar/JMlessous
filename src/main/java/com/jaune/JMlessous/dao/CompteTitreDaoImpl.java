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
import com.jaune.JMlessous.model.*;
import com.jaune.JMlessous.repository.ProduitsDerivesRepository;
import com.jaune.JMlessous.repository.CompteTitreRepository;
@Repository
public class CompteTitreDaoImpl {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	NamedParameterJdbcTemplate template;
	@Autowired
	private CompteTitreRepository CompteTitreRepository;
	@Autowired
	private ProduitsDerivesRepository prdruitDRepository;
	
	
	public ResponseEntity<CompteTitre> affecterProduitsDerivésCopmteTitre(int pdId, int cptId) throws ResourceNotFoundException {

		
		ProduitsDerives prd = prdruitDRepository.findById(pdId) 
				.orElseThrow(() -> new ResourceNotFoundException("product not found for this id :: " + pdId));
		CompteTitre cpt = CompteTitreRepository.findById(cptId)
				.orElseThrow(() -> new ResourceNotFoundException("account not found for this id :: " + cptId));
		
			if(cpt.getProduit() == null){
				List<ProduitsDerives> produits = new ArrayList<>();
				produits.add(prd);
				cpt.setProduit(produits);
			}else{
			cpt.getProduit().add(prd);
			}
			
			 final CompteTitre updatecpt= CompteTitreRepository.save(cpt);
		        return ResponseEntity.ok(updatecpt);
		
	}
	
	public List<CompteTitre> getAllCompte() {
        return CompteTitreRepository.findAll();
    }


    public ResponseEntity<CompteTitre> getCompteTitreById(int cptId)
        throws ResourceNotFoundException {
    	CompteTitre cpt = CompteTitreRepository.findById(cptId)
          .orElseThrow(() -> new ResourceNotFoundException("compteTitre not found for this id :: " + cptId));
        return ResponseEntity.ok().body(cpt);
    }
    

    public CompteTitre createCompteTitre( CompteTitre cpT) {
        return CompteTitreRepository.save(cpT);
    } 


    public ResponseEntity<CompteTitre> updateCompteT(int cptId,
    		CompteTitre cptDetails) throws ResourceNotFoundException {
    	CompteTitre cpT = CompteTitreRepository.findById(cptId)
        .orElseThrow(() -> new ResourceNotFoundException("account not found for this id :: " + cptId));

    	cpT.setNombre(cptDetails.getNombre());
       cpT.setProduit((cptDetails.getProduit()));
        final CompteTitre updateCompteT= CompteTitreRepository.save(cpT);
        return ResponseEntity.ok(updateCompteT);
    }


    public Map<String, Boolean> deleteCompteTitre(int compteId)
         throws ResourceNotFoundException {
    	CompteTitre compteTitre = CompteTitreRepository.findById(compteId)
       .orElseThrow(() -> new ResourceNotFoundException("account not found for this id :: " + compteId));

    	CompteTitreRepository.delete(compteTitre);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
