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

import com.jaune.JMlessous.dao.ChequeDaoImpl;

import com.jaune.JMlessous.exception.ResourceNotFoundException;
import com.jaune.JMlessous.model.Cheque;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/cheque")
public class ChequeController {
	
	
	 @Autowired
	ChequeDaoImpl chequeDaoImpl;	


	
	 @GetMapping("/all")
	    public List<Cheque> getAllCheque() {
	        return chequeDaoImpl.getAllCheque();
	    }
	
	    @GetMapping("/{id}")
	    public ResponseEntity<Cheque> getChequeById(@PathVariable(value = "id") int ChequeId)
	        throws ResourceNotFoundException {	    	
	        return chequeDaoImpl.getChequeById(ChequeId);
	    }
	    
	    @PostMapping("/add")
	    public Cheque createCheque(@Validated @RequestBody Cheque Cheque) {
	        return chequeDaoImpl.createCheque(Cheque);
	    }

	    @PutMapping("/update/{id}")
	    public ResponseEntity<Cheque> updateCheque(@PathVariable(value = "id") int ChequeId,
	         @Validated @RequestBody Cheque ChequeDetails) throws ResourceNotFoundException {
	    
	        return chequeDaoImpl.updateCheque(ChequeId, ChequeDetails);
	    }

	    @DeleteMapping("/del/{id}")
	    public Map<String, Boolean> deleteCheque(@PathVariable(value = "id") int ChequeId)
	         throws ResourceNotFoundException {	    	
	        return chequeDaoImpl.deleteCheque(ChequeId);
	    }
	}


