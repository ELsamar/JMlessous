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
import com.jaune.JMlessous.dao.AttributCompteCourantDaoIml;
import com.jaune.JMlessous.exception.ResourceNotFoundException;
import com.jaune.JMlessous.model.AttributAssurance;
import com.jaune.JMlessous.model.AttributCompteCourant;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/attributcomptecourant")
public class AttributCompteCourantController {
		
	 @Autowired
	 AttributCompteCourantDaoIml attributCompteCourantDaoIml;	
	 @GetMapping("/all")
	    public List<AttributCompteCourant> getAllattrCpt() {
	        return attributCompteCourantDaoIml.getAllattrCpt();
	    }
	
	    @GetMapping("/{id}")
	    public ResponseEntity<AttributCompteCourant> getattcptById(@PathVariable(value = "id") int attributcptID)
	        throws ResourceNotFoundException {	    	
	        return attributCompteCourantDaoIml.getattcptById(attributcptID);
	    }
	    
	    @PostMapping("/add")
	    public AttributCompteCourant createattrCpt(@Validated @RequestBody AttributCompteCourant attributCompteCourant) {
	        return attributCompteCourantDaoIml.createattrCpt(attributCompteCourant);
	    }
}
