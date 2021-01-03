package com.jaune.JMlessous.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jaune.JMlessous.exception.ResourceNotFoundException;
import com.jaune.JMlessous.model.AttributAssurance;
import com.jaune.JMlessous.model.AttributCompteCourant;
import com.jaune.JMlessous.repository.AttributAssuranceRepository;
import com.jaune.JMlessous.repository.AttributCompteCourantRepository;

@Repository
public class AttributCompteCourantDaoIml {
		@Autowired
	    private JdbcTemplate jdbcTemplate;
		NamedParameterJdbcTemplate template;
			@Autowired
		private AttributCompteCourantRepository attributCompteCourantRepository;
			
		public AttributCompteCourant createattrCpt( AttributCompteCourant attributCompteCourant) {
			        return attributCompteCourantRepository.save(attributCompteCourant);
			    } 
		public List<AttributCompteCourant> getAllattrCpt() {
	        return attributCompteCourantRepository.findAll();
	    }
		  public ResponseEntity<AttributCompteCourant> getattcptById(int attributcptID)
			        throws ResourceNotFoundException {
			  AttributCompteCourant attributCompteCourant = attributCompteCourantRepository.findById(attributcptID)
			          .orElseThrow(() -> new ResourceNotFoundException("AttributCompteCourant not found for this id :: " + attributcptID));
			        return ResponseEntity.ok().body(attributCompteCourant);
			    }
}
