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

import com.jaune.JMlessous.dao.CompteTitreDaoImpl;
import com.jaune.JMlessous.exception.ResourceNotFoundException;
import com.jaune.JMlessous.model.CompteTitre;


	@RestController
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/api/compteTitre")
	public class CompteTitreController {
		@Resource
		CompteTitreDaoImpl  compteTDaoImpl;	
		@PutMapping("/{idprod}/{idCpt}")
		public ResponseEntity<CompteTitre> affecterProduitCompte(@PathVariable(value = "id") int prodId,@PathVariable(value = "numCompte") int cptId) 
				throws ResourceNotFoundException {
		return compteTDaoImpl.affecterProduitsDerivésCopmteTitre(prodId, cptId);
		      
		}

	 @GetMapping("/all")
	    public List<CompteTitre> getAllComptes() {
	        return  compteTDaoImpl.getAllCompte();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<CompteTitre> getcompteById(@PathVariable(value = "id") int cptId)
	        throws ResourceNotFoundException {
	    	 return compteTDaoImpl.getCompteTitreById(cptId);
	    }
	    
	    @PostMapping("/add")
	    public CompteTitre createCompte(@Validated @RequestBody CompteTitre cpt) {
	        return compteTDaoImpl.createCompteTitre(cpt);
	    }

	    @PutMapping("/update/{id}")
	    public ResponseEntity<CompteTitre> updateCompte(@PathVariable(value = "id") int cptId,
	         @Validated @RequestBody CompteTitre cptDetails) throws ResourceNotFoundException {
	    
	        return compteTDaoImpl.updateCompteT(cptId, cptDetails);
	    }

	    @DeleteMapping("/delete/{id}")
	    public Map<String, Boolean> deleteCompte(@PathVariable(value = "id") int cptId)
	         throws ResourceNotFoundException {		    	
	        return compteTDaoImpl.deleteCompteTitre(cptId);
	    }

}
