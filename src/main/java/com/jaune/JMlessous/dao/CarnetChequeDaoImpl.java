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
import com.jaune.JMlessous.model.CarnetCheque;
import com.jaune.JMlessous.repository.CarnetChequeRepository;



@Repository
public class CarnetChequeDaoImpl {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	NamedParameterJdbcTemplate template;
	@Autowired
	private CarnetChequeRepository carnetChequeRepository;
	
	    public List<CarnetCheque> getAllCarnetCheque() {
	        return carnetChequeRepository.findAll();
	    }
	

	    public ResponseEntity<CarnetCheque> getCarnetChequeById(int CarnetChequeId)
	        throws ResourceNotFoundException {
	    	CarnetCheque CarnetCheque = carnetChequeRepository.findById(CarnetChequeId)
	          .orElseThrow(() -> new ResourceNotFoundException("CarnetCheque not found for this id :: " + CarnetChequeId));
	        return ResponseEntity.ok().body(CarnetCheque);
	    }
	    
	 
	    public CarnetCheque createCarnetCheque( CarnetCheque CarnetCheque) {
	        return carnetChequeRepository.save(CarnetCheque);
	    }

	
	    public ResponseEntity<CarnetCheque> updateCarnetCheque(int CarnetChequeId, CarnetCheque CarnetChequeDetails) throws ResourceNotFoundException {
	    	CarnetCheque CarnetCheque = carnetChequeRepository.findById(CarnetChequeId)
	        .orElseThrow(() -> new ResourceNotFoundException("Carte not found for this id :: " + CarnetChequeId));

	    	CarnetCheque.setBarre(CarnetChequeDetails.getBarre());
	    	CarnetCheque.setDatelivre(CarnetChequeDetails.getDatelivre());
	    	CarnetCheque.setDatedemande(CarnetChequeDetails.getDatedemande());
	    	CarnetCheque.setStatut(CarnetChequeDetails.getStatut());
	    	CarnetCheque.setNb(CarnetChequeDetails.getNb());
	        final CarnetCheque updatedCarnetCheque = carnetChequeRepository.save(CarnetCheque);
	        return ResponseEntity.ok(updatedCarnetCheque);
	    }

	 
	    public Map<String, Boolean> deleteCarnetCheque(int CarnetChequeId)
	         throws ResourceNotFoundException {
	    	CarnetCheque CarnetCheque= carnetChequeRepository.findById(CarnetChequeId)
	       .orElseThrow(() -> new ResourceNotFoundException("CarnetCheque not found for this id :: " + CarnetChequeId));

	    	carnetChequeRepository.delete(CarnetCheque);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
}
