package com.jaune.JMlessous.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaune.JMlessous.dao.AttributAssuranceDaoIml;
import com.jaune.JMlessous.exception.ResourceNotFoundException;
import com.jaune.JMlessous.model.AttributAssurance;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/attributassurance")
public class AttributAssuranceController {
		
	 @Autowired
	 AttributAssuranceDaoIml attributAssuranceDaoIml;	
	 @GetMapping("/all")
	    public List<AttributAssurance> getAllClient() {
	        return attributAssuranceDaoIml.getAllattrAssuurance();
	    }
	
	    @GetMapping("/{id}")
	    public ResponseEntity<AttributAssurance> getClientById(@PathVariable(value = "id") int attributAssuranceID)
	        throws ResourceNotFoundException {	    	
	        return attributAssuranceDaoIml.getattrAssuranceById(attributAssuranceID);
	    }
	    
	    @PostMapping("/add")
	    public AttributAssurance createEmploye(@Validated @RequestBody AttributAssurance attributAssurance) {
	        return attributAssuranceDaoIml.createattrAssuurance(attributAssurance);
	    }
}
