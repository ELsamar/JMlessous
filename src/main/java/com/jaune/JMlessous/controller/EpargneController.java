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

import com.jaune.JMlessous.dao.EpargneDaoImpl;
import com.jaune.JMlessous.dao.ProduitAssuranceDaoImpl;
import com.jaune.JMlessous.exception.ResourceNotFoundException;
import com.jaune.JMlessous.model.Conge;
import com.jaune.JMlessous.model.CompteEpargne;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/epargne")
public class EpargneController {
	 
	
@Resource
EpargneDaoImpl  epargneDaoImpl;
	
		
	  
		 @GetMapping("/allEpargne")
		    public List<CompteEpargne> getAllEpargne() {
		        return epargneDaoImpl.getAllCompteEpargne();
		    }
		
		    @GetMapping("/{id}")
		    public ResponseEntity<CompteEpargne> getCompteEpById(@PathVariable(value = "id") int epargneid)
		        throws ResourceNotFoundException {
		    	 return epargneDaoImpl.getCompteEpargneById(epargneid);
		    }
		    
		    @PostMapping("/addEpargne")
		    public CompteEpargne createEpargne(@Validated @RequestBody CompteEpargne compteepargne) {
		        return epargneDaoImpl.createCompteEpargne(compteepargne);
		    }

		    @PutMapping("/updateEpargne/{id}")
		    public ResponseEntity<CompteEpargne> updateEpargne(@PathVariable(value = "id") int epargneId,
		         @Validated @RequestBody CompteEpargne ccDetails) throws ResourceNotFoundException {
		    
		        return epargneDaoImpl.updateCompteEpargne(epargneId, ccDetails);
		    }

		    @DeleteMapping("/deleteEpargne/{id}")
		    public Map<String, Boolean> deleteEpargne(@PathVariable(value = "id") int epargneId)
		         throws ResourceNotFoundException {		    	
		        return epargneDaoImpl.deleteCompteCourant(epargneId);
		    }
		

}
