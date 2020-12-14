package com.jaune.JMlessous.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jaune.JMlessous.exception.ResourceNotFoundException;
import com.jaune.JMlessous.model.AttributAssurance;

import com.jaune.JMlessous.repository.AttributAssuranceRepository;

@Repository
public class AttributAssuranceDaoIml {
		@Autowired
	    private JdbcTemplate jdbcTemplate;
		NamedParameterJdbcTemplate template;
			@Autowired
		private AttributAssuranceRepository attrAssuRepository;
			
		public AttributAssurance createattrAssuurance( AttributAssurance attributAssurance) {
			        return attrAssuRepository.save(attributAssurance);
			    } 
		public List<AttributAssurance> getAllattrAssuurance() {
	        return attrAssuRepository.findAll();
	    }
		  public ResponseEntity<AttributAssurance> getattrAssuranceById(int attributAssuranceID)
			        throws ResourceNotFoundException {
			  AttributAssurance attributAssurance = attrAssuRepository.findById(attributAssuranceID)
			          .orElseThrow(() -> new ResourceNotFoundException("attributAssurance not found for this id :: " + attributAssuranceID));
			        return ResponseEntity.ok().body(attributAssurance);
			    }
}
