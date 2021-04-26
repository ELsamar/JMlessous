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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jaune.JMlessous.dao.ProduitsDerivesDaoImpl;
import com.jaune.JMlessous.exception.ResourceNotFoundException;
import com.jaune.JMlessous.model.ProduitsDerives;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/produitD")
public class ProduitsDerivéesController {
	@Autowired
	ProduitsDerivesDaoImpl pdDaoImp;	
	 @GetMapping("/all")
	    public List<ProduitsDerives> getAlProd() {
	        return pdDaoImp.getAllprodDerives();
	    }
	
	    @GetMapping("/{id}")
	    public ResponseEntity<ProduitsDerives> getProduitById(@PathVariable(value = "id") int produitsDerivesID)
	        throws ResourceNotFoundException {	    	
	        return pdDaoImp.getProdById(produitsDerivesID);
	    }
	    
	    @PostMapping("/add")
	    public ProduitsDerives createProduit(@Validated @RequestBody ProduitsDerives produitsDerives) {
	        return pdDaoImp.createprodDerives(produitsDerives);
	    }
	    @GetMapping("/offre")
	   public List<String> offre() {
	     return pdDaoImp.Offres();
	    }
	    
	    @DeleteMapping("/delete/{id}")
	    public Map<String, Boolean> deleteProd(@PathVariable(value = "id") int prodId)
	         throws ResourceNotFoundException {		    	
	        return pdDaoImp.deleteProd(prodId);
	    }
}
