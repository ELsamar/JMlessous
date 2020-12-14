package com.jaune.JMlessous.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jaune.JMlessous.exception.ResourceNotFoundException;
import com.jaune.JMlessous.model.Client;
import com.jaune.JMlessous.repository.ClientRepository;



@Repository
public class ClientDaoImpl {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	NamedParameterJdbcTemplate template;
	@Autowired
	private ClientRepository clientRepository;
	
	
	@SuppressWarnings("deprecation")
	public Client findByClient(String username,String password)    throws ResourceNotFoundException{
		 return jdbcTemplate.queryForObject
		          ("SELECT * FROM client WHERE username = ? AND password = ?",
		          new Object[] { username, password }, 
		          new BeanPropertyRowMapper<Client>(Client.class));		        
		 }

	    public List<Client> getAllClient() {
	        return clientRepository.findAll();
	    }
	

	    public ResponseEntity<Client> getClientById(int employeId)
	        throws ResourceNotFoundException {
	    	Client client = clientRepository.findById(employeId)
	          .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + employeId));
	        return ResponseEntity.ok().body(client);
	    }
	    
	 
	    public Client createClient( Client client) {
	        return clientRepository.save(client);
	    }

	
	    public ResponseEntity<Client> updateClient(int clientId, Client clientDetails) throws ResourceNotFoundException {
	    	Client client = clientRepository.findById(clientId)
	        .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + clientId));

	    	client.setMail(clientDetails.getMail());
	    	client.setUsername(clientDetails.getUsername());
	    	client.setPassword(clientDetails.getPassword());
	        final Client updatedclient = clientRepository.save(client);
	        return ResponseEntity.ok(updatedclient);
	    }

	 
	    public Map<String, Boolean> deleteClient(int clientId)
	         throws ResourceNotFoundException {
	    	Client client= clientRepository.findById(clientId)
	       .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + clientId));

	    	clientRepository.delete(client);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
}
