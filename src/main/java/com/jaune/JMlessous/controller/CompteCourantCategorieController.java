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

import com.jaune.JMlessous.dao.CompteCourantCategorieDaoImpl;
import com.jaune.JMlessous.dao.CongeDaoImpl;
import com.jaune.JMlessous.dao.ProduitAssuranceDaoImpl;
import com.jaune.JMlessous.exception.ResourceNotFoundException;
import com.jaune.JMlessous.model.CompteCourantCategorie;
import com.jaune.JMlessous.model.Conge;
import com.jaune.JMlessous.model.ProduitAssurance;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/comptecourantcategorie")
public class CompteCourantCategorieController {
	 
	
@Resource
CompteCourantCategorieDaoImpl  compteCourantCategorieDaoImpl;
	
		@PutMapping("/{idatt}/{idcpt}")
			public ResponseEntity<CompteCourantCategorie> affecterAttributCpt(@PathVariable(value = "idatt") int attrId,@PathVariable(value = "idcpt") int cptId) 
					throws ResourceNotFoundException {
			return compteCourantCategorieDaoImpl.affecterAttributCpt(attrId, cptId);
			      
			}
	  
		 @GetMapping("/all")
		    public List<CompteCourantCategorie> getAllCpt() {
		        return compteCourantCategorieDaoImpl.getAllCpt();
		    }
		
		    @GetMapping("/{id}")
		    public ResponseEntity<CompteCourantCategorie> getCptById(@PathVariable(value = "id") int cptId)
		        throws ResourceNotFoundException {
		    	 return compteCourantCategorieDaoImpl.getCptById(cptId);
		    }
		    
		    @PostMapping("/add")
		    public CompteCourantCategorie createCpt(@Validated @RequestBody CompteCourantCategorie cpt) {
		        return compteCourantCategorieDaoImpl.createCpt(cpt);
		    }

		    @PutMapping("/update/{id}")
		    public ResponseEntity<CompteCourantCategorie> updateCpt(@PathVariable(value = "id") int cptId,
		         @Validated @RequestBody CompteCourantCategorie cptDetails) throws ResourceNotFoundException {
		    
		        return compteCourantCategorieDaoImpl.updateCpt(cptId, cptDetails);
		    }

		    @DeleteMapping("/dell/{id}")
		    public Map<String, Boolean> deleteCpt(@PathVariable(value = "id") int cptId)
		         throws ResourceNotFoundException {		    	
		        return compteCourantCategorieDaoImpl.deleteCpt(cptId);
		    }
		

}
