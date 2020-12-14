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

import com.jaune.JMlessous.dao.ClientDaoImpl;

import com.jaune.JMlessous.exception.ResourceNotFoundException;
import com.jaune.JMlessous.model.Client;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/client")
public class ClientController {
	
	
	 @Autowired
	 ClientDaoImpl clientDaoImpl;	


	@GetMapping(value = "/login/{username}/{password}")
	public Client login(@PathVariable(value = "username") String username,@PathVariable(value = "password") String password) throws ResourceNotFoundException {
	return clientDaoImpl.findByClient(username, password);
	}
	
	
	 @GetMapping("/all")
	    public List<Client> getAllClient() {
	        return clientDaoImpl.getAllClient();
	    }
	
	    @GetMapping("/{id}")
	    public ResponseEntity<Client> getClientById(@PathVariable(value = "id") int clientId)
	        throws ResourceNotFoundException {	    	
	        return clientDaoImpl.getClientById(clientId);
	    }
	    
	    @PostMapping("/add")
	    public Client createEmploye(@Validated @RequestBody Client client) {
	        return clientDaoImpl.createClient(client);
	    }

	    @PutMapping("/update/{id}")
	    public ResponseEntity<Client> updateClient(@PathVariable(value = "id") int clientId,
	         @Validated @RequestBody Client clientDetails) throws ResourceNotFoundException {
	    
	        return clientDaoImpl.updateClient(clientId, clientDetails);
	    }

	    @DeleteMapping("/del/{id}")
	    public Map<String, Boolean> deleteClient(@PathVariable(value = "id") int clientId)
	         throws ResourceNotFoundException {	    	
	        return clientDaoImpl.deleteClient(clientId);
	    }
	}


