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

import com.jaune.JMlessous.dao.ContratDaoImpl;
import com.jaune.JMlessous.exception.ResourceNotFoundException;
import com.jaune.JMlessous.model.Contrat;
import com.jaune.JMlessous.model.ProduitAssurance;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/contrat")
public class ContratController {
	 @Autowired
		ContratDaoImpl contratDaoImpl;	
	 @GetMapping("/all")
	    public List<Contrat> getAllContrats() {
	        return contratDaoImpl.getAllContrats();
	    }
	 ///delete contrat
	   @DeleteMapping("/contrat/{id}")
	    public Map<String, Boolean> deleteContrat(@PathVariable(value = "id") int contratId)
	         throws ResourceNotFoundException {	    	
	        return contratDaoImpl.deleteContrat(contratId);
	    }
//Ajouter un contrat
	   @PostMapping("/add")
	    public Contrat createContrat(@Validated @RequestBody Contrat contrat) {
	        return contratDaoImpl.createContrat(contrat);
	   }
	   //Affecter un produit d'assurance  a un contrat
	   @PutMapping("/{idpdassurance}/{idcontrat}")
		public ResponseEntity<Contrat> affecterAttributPdAssurance(@PathVariable(value = "idpdassurance") int pdassuranceId,@PathVariable(value = "idcontrat") int contratId) 
				throws ResourceNotFoundException {
		return contratDaoImpl.affecterPdAssuranceContrat(pdassuranceId, contratId);
		      
		}
	   
	   //Affecter un client a un contrat
	   @PutMapping("/client/{idclient}/{idcontrat}")
	 		public ResponseEntity<Contrat> affecterclientContrat(@PathVariable(value = "idclient") int clientId,@PathVariable(value = "idcontrat") int contratId) 
	 				throws ResourceNotFoundException {
	 		return contratDaoImpl.affecterclientContrat(clientId, contratId);
	 		      
	 		}
	   //Affecter un client et un produit d'assurance a un contrat
	   @PutMapping("/{idclient}/{idpdassurance}/{idcontrat}")
		public ResponseEntity<Contrat> affecterclientpdassuranceContrat(@PathVariable(value = "idclient") int clientId,@PathVariable(value = "idpdassurance") int pdassuranceId,@PathVariable(value = "idcontrat") int contratId) 
				throws ResourceNotFoundException {
		return contratDaoImpl.affecterclientpdassuranceContrat(clientId,pdassuranceId, contratId);
		      
		}
	   //Affecter un client , un produit d'assurance  et attribut a un contrat
	   @PutMapping("/att/{idattributcontrat}/{idcontrat}")
		public ResponseEntity<Contrat>affecterclientpdassuranceContratAttribut(@PathVariable(value = "idattributcontrat")int attributContratId,@PathVariable(value = "idcontrat") int contratId) 
				throws ResourceNotFoundException {
		return contratDaoImpl.affecterclientpdassuranceContratAttribut(attributContratId,contratId);
		      
		}
	   //trouver un contrat un idpdassurance
	   @PutMapping("/tr/{idpdassurance}")
		public ResponseEntity<Contrat>getContartByIdpdassurance(@PathVariable(value = "idpdassurance")int pdassuranceId) 
				throws ResourceNotFoundException {
		return contratDaoImpl.getContartByIdpdassurance(pdassuranceId);
		      
		}
	   //trouver un contrat un idpdassurance
	   @GetMapping("/tc/{idclient}")
		public List<Contrat>getContratByIdClient(@PathVariable(value = "idclient")int clientId) throws ResourceNotFoundException 
				 {
		return contratDaoImpl.getContratByIdClient(clientId);
		      
		}
	   ///findByIdPartenaireAssurance
	   @GetMapping("/partenaire/{idpartenaireassurance}")
		public List<Contrat>findByIdPartenaireAssurance(@PathVariable(value = "idpartenaireassurance")int partenaireassuranceId) throws ResourceNotFoundException 
				 {
		return contratDaoImpl.findByIdPartenaireAssurance(partenaireassuranceId);
		      
		}
	   
}
