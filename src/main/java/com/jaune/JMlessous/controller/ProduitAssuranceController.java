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

import com.jaune.JMlessous.dao.CongeDaoImpl;
import com.jaune.JMlessous.dao.ProduitAssuranceDaoImpl;
import com.jaune.JMlessous.exception.ResourceNotFoundException;
import com.jaune.JMlessous.model.Conge;
import com.jaune.JMlessous.model.ProduitAssurance;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/pdassurance")
public class ProduitAssuranceController {
	 
	
@Resource
ProduitAssuranceDaoImpl  produitAssuranceDaoImpl;
	
		@PutMapping("/{idatt}/{idpd}")
			public ResponseEntity<ProduitAssurance> affecterAttributPdAssurance(@PathVariable(value = "idatt") int attrId,@PathVariable(value = "idpd") int pdassId) 
					throws ResourceNotFoundException {
			return produitAssuranceDaoImpl.affecterAttributPdAssurance(attrId, pdassId);
			      
			}
	  
		 @GetMapping("/all")
		    public List<ProduitAssurance> getAllPdAsurance() {
		        return produitAssuranceDaoImpl.getAllPdAsurance();
		    }
		
		    @GetMapping("/{id}")
		    public ResponseEntity<ProduitAssurance> getPdAssuranceById(@PathVariable(value = "id") int pdassuranceId)
		        throws ResourceNotFoundException {
		    	 return produitAssuranceDaoImpl.getPdAssuranceById(pdassuranceId);
		    }
		    
		    @PostMapping("/add")
		    public ProduitAssurance createPdAssurance(@Validated @RequestBody ProduitAssurance pdaasurance) {
		        return produitAssuranceDaoImpl.createPdAssurance(pdaasurance);
		    }

		    @PutMapping("/update/{id}")
		    public ResponseEntity<ProduitAssurance> updateAssurance(@PathVariable(value = "id") int assuranceId,
		         @Validated @RequestBody ProduitAssurance pdaasuranceDetails) throws ResourceNotFoundException {
		    
		        return produitAssuranceDaoImpl.updateAssurance(assuranceId, pdaasuranceDetails);
		    }

		    @DeleteMapping("/dell/{id}")
		    public Map<String, Boolean> deleteAssurance(@PathVariable(value = "id") int congeId)
		         throws ResourceNotFoundException {		    	
		        return produitAssuranceDaoImpl.deleteAssurance(congeId);
		    }
		

}
