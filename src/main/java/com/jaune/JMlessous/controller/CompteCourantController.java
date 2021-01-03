package com.jaune.JMlessous.controller;

import java.util.Collection;
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
import com.jaune.JMlessous.dao.CompteCourantDaoIml;
import com.jaune.JMlessous.exception.ResourceNotFoundException;
import com.jaune.JMlessous.model.CompteCourant;




@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/comptecourant")
public class CompteCourantController {
		
	 @Autowired
	 CompteCourantDaoIml compteCourantDaoIml;	
	
	 
	 @GetMapping("/clientrip/{id}")
	    public CompteCourant getcptByrip(@PathVariable(value = "id") int rip) {
	        return compteCourantDaoIml.getcptByrip(rip);
	    }
	 @GetMapping("/client/{id}")
	    public List<CompteCourant> getcptByclient(@PathVariable(value = "id") int userID) {
	        return compteCourantDaoIml.getcptByClient(userID);
	    }
	 @GetMapping("/all")
	    public List<CompteCourant> getAllCpt() {
	        return compteCourantDaoIml.getAllCpt();
	    }
	
	    @GetMapping("/{id}")
	    public ResponseEntity<CompteCourant> getcptById(@PathVariable(value = "id") int cptID)
	        throws ResourceNotFoundException {	    	
	        return compteCourantDaoIml.getcptById(cptID);
	    }
	    
	    @PostMapping("/add")
	    public CompteCourant createCpt(@Validated @RequestBody CompteCourant CompteCourant) {
	        return compteCourantDaoIml.createCpt(CompteCourant);
	    }
	    @PutMapping("/update/{id}")
	    public ResponseEntity<CompteCourant> updateCpt(@PathVariable(value = "id") int cptId,
	         @Validated @RequestBody CompteCourant cptDetails) throws ResourceNotFoundException {
	    
	        return compteCourantDaoIml.updateCpt(cptId, cptDetails);
	    }

	    @DeleteMapping("/dell/{id}")
	    public Map<String, Boolean> deleteCpt(@PathVariable(value = "id") int cptId)
	         throws ResourceNotFoundException {		    	
	        return compteCourantDaoIml.deleteCpt(cptId);
	    }
}
