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
import com.jaune.JMlessous.model.Cheque;
import com.jaune.JMlessous.repository.ChequeRepository;



@Repository
public class ChequeDaoImpl {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	NamedParameterJdbcTemplate template;
	@Autowired
	private ChequeRepository chequeRepository;
	
	    public List<Cheque> getAllCheque() {
	        return chequeRepository.findAll();
	    }
	

	    public ResponseEntity<Cheque> getChequeById(int ChequeId)
	        throws ResourceNotFoundException {
	    	Cheque cheque = chequeRepository.findById(ChequeId)
	          .orElseThrow(() -> new ResourceNotFoundException("Cheque not found for this id :: " + ChequeId));
	        return ResponseEntity.ok().body(cheque);
	    }
	    
	 
	    public Cheque createCheque( Cheque Cheque) {
	        return chequeRepository.save(Cheque);
	    }

	
	    public ResponseEntity<Cheque> updateCheque(int ChequeId, Cheque ChequeDetails) throws ResourceNotFoundException {
	    	Cheque Cheque = chequeRepository.findById(ChequeId)
	        .orElseThrow(() -> new ResourceNotFoundException("Cheque not found for this id :: " + ChequeId));

	    	Cheque.setNumero(ChequeDetails.getNumero());
	    	Cheque.setDateRemise(ChequeDetails.getDateRemise());
	    	
	        final Cheque updatedCheque = chequeRepository.save(Cheque);
	        return ResponseEntity.ok(updatedCheque);
	    }

	 
	    public Map<String, Boolean> deleteCheque(int ChequeId)
	         throws ResourceNotFoundException {
	    	Cheque Cheque= chequeRepository.findById(ChequeId)
	       .orElseThrow(() -> new ResourceNotFoundException("Cheque not found for this id :: " + ChequeId));

	    	chequeRepository.delete(Cheque);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
}
