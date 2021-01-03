package com.jaune.JMlessous.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jaune.JMlessous.exception.ResourceNotFoundException;
import com.jaune.JMlessous.model.Carte;
import com.jaune.JMlessous.model.CompteCourant;
import com.jaune.JMlessous.model.Operation;
import com.jaune.JMlessous.repository.CompteCourantRepository;
import com.jaune.JMlessous.repository.OperationRepository;

@Repository
public class OperationDaoImpl {
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private CompteCourantRepository compteCourantRepository;
	
	Map<String, Float> tauxchange = new HashMap<String, Float>() {{
	    put("TND-EUR", (float) 0.304808);
	    put("EUR-TND", (float) 3.28075);
	    put("TND-USD", (float) 0.374218);
	    put("USD-EUR", (float)  0.816222);
	    put("EUR-USD", (float) 1.22519);
	    
	}};

	public List<Operation> findOpByCptStatut (String statut, int id){
		return operationRepository.findOpByCptStatut(statut,id);
	}
	public List<Operation> findOpByCpt (int id){
		return operationRepository.findOpByCpt(id);
	}
	public List<Operation> findOpByStatut (String statut){
		return operationRepository.findOpByStatut(statut);
	}
	
    public Operation createOperation( Operation op,int id) throws ResourceNotFoundException{

    	CompteCourant cptClient =compteCourantRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("CompteCourant not found for this id :: " + id));
    
    	op.setComptecourant(cptClient);
    	Date d = new Date();
    	op.setDatevaleur(d);
    	op.setDateoperation(d);
    	op.setReference("Op"+(int)(Math.random() * 9000) + 1000);
    	return operationRepository.save(op);
		
    }
    public Operation virement( Operation op,int idCompteclient,int rip) throws ResourceNotFoundException{
    System.out.println(op.toString());
    	CompteCourant cptClient =compteCourantRepository.findById(idCompteclient).orElseThrow(() -> new ResourceNotFoundException("CompteCourant not found for this id :: " + idCompteclient));
    
    	float montantClient = op.getMontant();
    	if(!op.getDevise().equals(cptClient.getDevise()))
		{System.out.println("d5al if devise");
    		 montantClient = op.getMontant()*tauxchange.get(op.getDevise()+"-"+cptClient.getDevise());
    	}
        System.out.println(cptClient.getSolde());
        System.out.println(montantClient > cptClient.getSolde());
    	if(montantClient < cptClient.getSolde()) {
    		if(op.getInterBank()) {
    			op.setLibele("virement InterBank");
    			op.setReference("VIn"+(int)(Math.random() * 9000) + 1000);
    			op.setTaux((float) 0.5);    			
    			CompteCourant cptbeneficiaire =compteCourantRepository.findCptByRip(rip);
    		
    			if(cptbeneficiaire != null) {
    				
    				float montantbeneficiaire = op.getMontant();
    				if (!op.getDevise().equals(cptbeneficiaire.getDevise())) {
    					montantbeneficiaire = op.getMontant()*tauxchange.get(op.getDevise()+"-"+cptbeneficiaire.getDevise());
    				}
    				op.setStatut("réussite");
        			cptbeneficiaire.setSolde(cptbeneficiaire.getSolde()+montantbeneficiaire);
        			cptClient.setSolde(cptClient.getSolde()-montantClient-op.getTaux());
    			}else {
    	    		op.setStatut("échec Beneficiaire non trouve");    	
    	    	}
    		}else {
    			op.setLibele("virement ExterBank");
    			op.setReference("VEx"+(int)(Math.random() * 9000) + 1000);
    			op.setTaux((float) 1.5);  
    			op.setStatut("En cours");
    			cptClient.setSolde(cptClient.getSolde()-montantClient-op.getTaux());
    		}
    	}	else {
    		op.setStatut("échec montant insuffisant");    	
    	}
    	
    	Date d = new Date();
    	op.setDatevaleur(d);
    	op.setDateoperation(d);
    	op.setComptecourant(cptClient);
    	return operationRepository.save(op);
		
    }
	
}
