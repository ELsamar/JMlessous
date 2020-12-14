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

import com.jaune.JMlessous.dao.EmployeDaoImpl;
import com.jaune.JMlessous.exception.ResourceNotFoundException;
import com.jaune.JMlessous.model.Employe;
import com.jaune.JMlessous.model.User;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/employe")
public class EmployeController {
	
	
	 @Autowired
		EmployeDaoImpl employeDaoImpl;	
	 
	 
	 
	 @GetMapping(value = "/name")
		public List<Map<String, Object>> findAllEmployesname() {
		return employeDaoImpl.findAllEmployesname();
		}

	@GetMapping(value = "/login/{username}/{password}")
	public Employe login(@PathVariable(value = "username") String username,@PathVariable(value = "password") String password) throws ResourceNotFoundException {
	return employeDaoImpl.findByemploye(username, password);
	}
	
	
	 @GetMapping("/all")
	    public List<Employe> getAllEmployes() {
	        return employeDaoImpl.getAllEmployes();
	    }
	
	    @GetMapping("/{id}")
	    public ResponseEntity<Employe> getemployeById(@PathVariable(value = "id") int employeId)
	        throws ResourceNotFoundException {	    	
	        return employeDaoImpl.getemployeById(employeId);
	    }
	    
	    @PostMapping("/add")
	    public Employe createEmploye(@Validated @RequestBody Employe employe) {
	        return employeDaoImpl.createEmploye(employe);
	    }

	    @PutMapping("/update/{id}")
	    public ResponseEntity<Employe> updateEmploye(@PathVariable(value = "id") int employeId,
	         @Validated @RequestBody Employe employeDetails) throws ResourceNotFoundException {
	    
	        return employeDaoImpl.updateEmploye(employeId, employeDetails);
	    }

	    @DeleteMapping("/users/{id}")
	    public Map<String, Boolean> deleteEmploye(@PathVariable(value = "id") int employeId)
	         throws ResourceNotFoundException {	    	
	        return employeDaoImpl.deleteEmploye(employeId);
	    }
	}


