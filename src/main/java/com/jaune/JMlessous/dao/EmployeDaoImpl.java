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
import com.jaune.JMlessous.model.Employe;
import com.jaune.JMlessous.model.User;
import com.jaune.JMlessous.repository.EmployeRepository;


@Repository
public class EmployeDaoImpl {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	NamedParameterJdbcTemplate template;
	@Autowired
	private EmployeRepository employeRepository;
	
	
	public List<Map<String, Object>> findAllEmployesname() {
		
		return jdbcTemplate.queryForList("SELECT nom FROM employe group BY id ");
	}

	
	@SuppressWarnings("deprecation")
	public Employe findByemploye(String username,String password)    throws ResourceNotFoundException{
		 return jdbcTemplate.queryForObject
		          ("SELECT * FROM employe WHERE username = ? AND password = ?",
		          new Object[] { username, password }, 
		          new BeanPropertyRowMapper<Employe>(Employe.class));		        
		 }

	    public List<Employe> getAllEmployes() {
	        return employeRepository.findAll();
	    }
	

	    public ResponseEntity<Employe> getemployeById(int employeId)
	        throws ResourceNotFoundException {
	    	Employe employe = employeRepository.findById(employeId)
	          .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + employeId));
	        return ResponseEntity.ok().body(employe);
	    }
	    
	 
	    public Employe createEmploye( Employe employe) {
	        return employeRepository.save(employe);
	    }

	
	    public ResponseEntity<Employe> updateEmploye(int employeId, Employe employeDetails) throws ResourceNotFoundException {
	    	Employe employe = employeRepository.findById(employeId)
	        .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + employeId));

	    	employe.setMail(employeDetails.getMail());
	    	employe.setUsername(employeDetails.getUsername());
	    	employe.setPassword(employeDetails.getPassword());
	        final Employe updatedemploye = employeRepository.save(employe);
	        return ResponseEntity.ok(updatedemploye);
	    }

	 
	    public Map<String, Boolean> deleteEmploye(int employeId)
	         throws ResourceNotFoundException {
	    	Employe employe= employeRepository.findById(employeId)
	       .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + employeId));

	    	employeRepository.delete(employe);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
}
