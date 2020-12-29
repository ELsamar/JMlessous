package com.jaune.JMlessous.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jaune.JMlessous.exception.ResourceNotFoundException;
import com.jaune.JMlessous.model.AttributAssurance;
import com.jaune.JMlessous.model.ProduitAssurance;
import com.jaune.JMlessous.repository.AttributAssuranceRepository;
import com.jaune.JMlessous.repository.ProduitAssuranceRepository;


@Repository
public class ProduitAssuranceDaoImpl {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	NamedParameterJdbcTemplate template;
	@Autowired
	private ProduitAssuranceRepository produitAssuranceRepository;
	@Autowired
	private AttributAssuranceRepository attrAssuRepository;
	
	
	public ResponseEntity<ProduitAssurance> affecterAttributPdAssurance(int attrId, int pdassId) throws ResourceNotFoundException {

		
		AttributAssurance att = attrAssuRepository.findById(attrId) 
				.orElseThrow(() -> new ResourceNotFoundException("attr not found for this id :: " + attrId));
		ProduitAssurance pdaasurance = produitAssuranceRepository.findById(pdassId)
				.orElseThrow(() -> new ResourceNotFoundException("pdaasurance not found for this id :: " + pdassId));
		
			if(pdaasurance.getAttributs() == null){
				List<AttributAssurance> attributs = new ArrayList<>();
				attributs.add(att);
				pdaasurance.setAttributs(attributs);
			}else{
				pdaasurance.getAttributs().add(att);
			}
			
			 final ProduitAssurance updatepdaasurance= produitAssuranceRepository.save(pdaasurance);
		        return ResponseEntity.ok(updatepdaasurance);
		
	}
	
	public List<ProduitAssurance> getAllPdAsurance() {
        return produitAssuranceRepository.findAll();
    }


    public ResponseEntity<ProduitAssurance> getPdAssuranceById(int pdassuranceId)
        throws ResourceNotFoundException {
    	ProduitAssurance pdaasurance = produitAssuranceRepository.findById(pdassuranceId)
          .orElseThrow(() -> new ResourceNotFoundException("ProduitAssurance not found for this id :: " + pdassuranceId));
        return ResponseEntity.ok().body(pdaasurance);
    }
    

    public ProduitAssurance createPdAssurance( ProduitAssurance pdaasurance) {
        return produitAssuranceRepository.save(pdaasurance);
    } 


    public ResponseEntity<ProduitAssurance> updateAssurance(int assuranceId,
    		ProduitAssurance pdaasuranceDetails) throws ResourceNotFoundException {
    	ProduitAssurance pdaasurance = produitAssuranceRepository.findById(assuranceId)
        .orElseThrow(() -> new ResourceNotFoundException("assurance not found for this id :: " + assuranceId));

    	pdaasurance.setLibelle(pdaasuranceDetails.getLibelle());
    	pdaasurance.setAttributs((pdaasuranceDetails.getAttributs()));
        final ProduitAssurance updatepdaasurance= produitAssuranceRepository.save(pdaasurance);
        return ResponseEntity.ok(updatepdaasurance);
    }


    public Map<String, Boolean> deleteAssurance(int assuranceId)
         throws ResourceNotFoundException {
    	ProduitAssurance produitAssurance = produitAssuranceRepository.findById(assuranceId)
       .orElseThrow(() -> new ResourceNotFoundException("assurance not found for this id :: " + assuranceId));

    	produitAssuranceRepository.delete(produitAssurance);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    //Achéter un produit d'assurance
    
   
    

}
