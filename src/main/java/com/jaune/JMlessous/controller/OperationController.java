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

import com.jaune.JMlessous.dao.OperationDaoImpl;

import com.jaune.JMlessous.exception.ResourceNotFoundException;
import com.jaune.JMlessous.model.Carte;
import com.jaune.JMlessous.model.Operation;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/operation")
public class OperationController {
	
	
	 @Autowired
	 OperationDaoImpl operationDaoImpl;	
	   
	   
	  @GetMapping("/byCptstatut/{statut}/{id}")
	    public List<Operation> findOpByCptStatut(@PathVariable(value = "statut") String statut ,@PathVariable(value = "id") int id) {	    	
	        return operationDaoImpl.findOpByCptStatut(statut,id);
	    }
	 @GetMapping("/bycpt/{id}")
	    public List<Operation> findOpByCpt(@PathVariable(value = "id")int id) {
	        return operationDaoImpl.findOpByCpt(id);
	    }
	
	    @GetMapping("/bystatut/{statut}")
	    public List<Operation> findOpByStatut(@PathVariable(value = "statut") String statut) {	    	
	        return operationDaoImpl.findOpByStatut(statut);
	    }
	    
	    @PostMapping("/add/{id}")
	    public Operation createCarte(@Validated @RequestBody Operation op,@PathVariable(value = "id") int id) throws ResourceNotFoundException {
	        return operationDaoImpl.createOperation(op,id);
	    }

	    
	    @PostMapping("/virement/{id}/{rip}")
	    public Operation virement(@Validated @RequestBody Operation op,@PathVariable(value = "id") int idCompteclient
	    		,@PathVariable(value = "rip") int ripbeneficiaire) throws ResourceNotFoundException {
	        return operationDaoImpl.virement(op, idCompteclient, ripbeneficiaire);
	    }

	}


