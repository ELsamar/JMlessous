package com.jaune.JMlessous.controller;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

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

import com.jaune.JMlessous.dao.CongeDaoImpl;
import com.jaune.JMlessous.exception.ResourceNotFoundException;
import com.jaune.JMlessous.model.Conge;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class CongeController {
	 
	
@Resource
CongeDaoImpl  congeDaoImpl;
	
	    @PutMapping("/conge/accept/{id}")
	    public ResponseEntity<Conge> traiteConge(@PathVariable(value = "id") int congeId,@Validated @RequestBody String statut) throws ResourceNotFoundException {
	    
	        return congeDaoImpl.traiteConge(congeId, statut);
	    }
		 @GetMapping("/conge")
		    public List<Conge> getAllConge() {
		        return congeDaoImpl.getAllConge();
		    }
		
		    @GetMapping("/conge/{id}")
		    public ResponseEntity<Conge> getCongeById(@PathVariable(value = "id") int congeId)
		        throws ResourceNotFoundException {
		    	 return congeDaoImpl.getCongeById(congeId);
		    }
		    
		    @PostMapping("/conge")
		    public Conge createConge(@Validated @RequestBody Conge conge) {
		        return congeDaoImpl.createConge(conge);
		    }

		    @PutMapping("/conge/{id}")
		    public ResponseEntity<Conge> updateConge(@PathVariable(value = "id") int congeId,
		         @Validated @RequestBody Conge congeDetails) throws ResourceNotFoundException {
		    
		        return congeDaoImpl.updateConge(congeId,congeDetails);
		    }

		    @DeleteMapping("/conge/{id}")
		    public Map<String, Boolean> deleteConge(@PathVariable(value = "id") int congeId)
		         throws ResourceNotFoundException {		    	
		        return congeDaoImpl.deleteConge(congeId);
		    }
		

}
