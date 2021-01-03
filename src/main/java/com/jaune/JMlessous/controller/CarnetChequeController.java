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

import com.jaune.JMlessous.dao.CarnetChequeDaoImpl;

import com.jaune.JMlessous.exception.ResourceNotFoundException;
import com.jaune.JMlessous.model.CarnetCheque;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/carnetcheque")
public class CarnetChequeController {
	
	
	 @Autowired
	 CarnetChequeDaoImpl carnetChequeDaoImpl;	


	
	 @GetMapping("/all")
	    public List<CarnetCheque> getAllCarnetCheque() {
	        return carnetChequeDaoImpl.getAllCarnetCheque();
	    }
	
	    @GetMapping("/{id}")
	    public ResponseEntity<CarnetCheque> getCarnetChequeById(@PathVariable(value = "id") int CarnetChequeId)
	        throws ResourceNotFoundException {	    	
	        return carnetChequeDaoImpl.getCarnetChequeById(CarnetChequeId);
	    }
	    
	    @PostMapping("/add")
	    public CarnetCheque createCarnetCheque(@Validated @RequestBody CarnetCheque CarnetCheque) {
	        return carnetChequeDaoImpl.createCarnetCheque(CarnetCheque);
	    }

	    @PutMapping("/update/{id}")
	    public ResponseEntity<CarnetCheque> updateCarnetCheque(@PathVariable(value = "id") int CarnetChequeId,
	         @Validated @RequestBody CarnetCheque CarnetChequeDetails) throws ResourceNotFoundException {
	    
	        return carnetChequeDaoImpl.updateCarnetCheque(CarnetChequeId, CarnetChequeDetails);
	    }

	    @DeleteMapping("/del/{id}")
	    public Map<String, Boolean> deleteCarnetCheque(@PathVariable(value = "id") int CarnetChequeId)
	         throws ResourceNotFoundException {	    	
	        return carnetChequeDaoImpl.deleteCarnetCheque(CarnetChequeId);
	    }
	}


