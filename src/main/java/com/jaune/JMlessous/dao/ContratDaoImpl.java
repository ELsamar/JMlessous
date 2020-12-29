package com.jaune.JMlessous.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jaune.JMlessous.exception.ResourceNotFoundException;
import com.jaune.JMlessous.model.AttributAssurance;
import com.jaune.JMlessous.model.AttributContrat;
import com.jaune.JMlessous.model.Client;
import com.jaune.JMlessous.model.Contrat;
import com.jaune.JMlessous.model.Employe;
import com.jaune.JMlessous.model.ProduitAssurance;
import com.jaune.JMlessous.repository.AttributAssuranceRepository;
import com.jaune.JMlessous.repository.AttributContratRepository;
import com.jaune.JMlessous.repository.ClientRepository;
import com.jaune.JMlessous.repository.ContratByIdpdAssuranceRepository;
import com.jaune.JMlessous.repository.ContratRepository;
import com.jaune.JMlessous.repository.ProduitAssuranceRepository;

@Repository
public class ContratDaoImpl {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	NamedParameterJdbcTemplate template;
	@Autowired
	private ContratRepository contratRepository;
	@Autowired
	private ProduitAssuranceRepository produitAssuranceRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private AttributContratRepository attributcontratRepository;
	@Autowired
	private ContratByIdpdAssuranceRepository contratByIdpdAssuranceRepository;
	
	 public List<Contrat> getAllContrats() {
	        return contratRepository.findAll();
	    }
	    public Map<String, Boolean> deleteContrat(int contratId)
		         throws ResourceNotFoundException {
		    	Contrat contrat= contratRepository.findById(contratId)
		       .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + contratId));

		    	contratRepository.delete(contrat);
		        Map<String, Boolean> response = new HashMap<>();
		        response.put("deleted", Boolean.TRUE);
		        return response;
		    }
	    public Contrat createContrat( Contrat contrat) {
	        return contratRepository.save(contrat);
	    }
	    //Affecter un produit d'assurance a un  contrat
		public ResponseEntity<Contrat> affecterPdAssuranceContrat( int pdassId,int contratId) throws ResourceNotFoundException {

			
			ProduitAssurance pd = produitAssuranceRepository.findById(pdassId) 
					.orElseThrow(() -> new ResourceNotFoundException("produitassurance not found for this id :: " + pdassId));
			Contrat contrat = contratRepository.findById(contratId)
					.orElseThrow(() -> new ResourceNotFoundException("contrat not found for this id :: " + contratId));
			
				if(contrat.getProduitassurance() == null){
					List<ProduitAssurance> pdassurance = new ArrayList<>();
					pdassurance.add(pd);
					contrat.setProduitassurance(pd);
				}
				
				 final Contrat updatecontrat=contratRepository.save(contrat);
			        return ResponseEntity.ok(updatecontrat);
			
		}
		//affecter un client a un contrat
public ResponseEntity<Contrat> affecterclientContrat( int clientId,int contratId) throws ResourceNotFoundException {

			
			Client pd =clientRepository.findById(clientId) 
					.orElseThrow(() -> new ResourceNotFoundException("produitassurance not found for this id :: " +clientId));
			Contrat contrat = contratRepository.findById(contratId)
					.orElseThrow(() -> new ResourceNotFoundException("contrat not found for this id :: " + contratId));
			
				if(contrat.getClient() == null){
					List<Client> client = new ArrayList<>();
					client.add(pd);
					contrat.setClient(pd);;
				}
				
				 final Contrat updatecontrat=contratRepository.save(contrat);
			        return ResponseEntity.ok(updatecontrat);
			
		}
//affecter un client et un produit d'assurance a un contrat
public ResponseEntity<Contrat> affecterclientpdassuranceContrat( int clientId,int pdassuranceId,int contratId) throws ResourceNotFoundException {

	
	Client cl =clientRepository.findById(clientId) 
			.orElseThrow(() -> new ResourceNotFoundException("client not found for this id :: " +clientId));
	ProduitAssurance pd = produitAssuranceRepository.findById(pdassuranceId)		
			.orElseThrow(() -> new ResourceNotFoundException("produitassurance not found for this id :: " +pdassuranceId));
    Contrat contrat = contratRepository.findById(contratId)
			.orElseThrow(() -> new ResourceNotFoundException("contrat not found for this id :: " + contratId));
	
		if(contrat.getClient() == null && contrat.getProduitassurance() == null ){
			List<ProduitAssurance> pdassurance = new ArrayList<>();
			pdassurance.add(pd);
			contrat.setProduitassurance(pd);
			List<Client> client = new ArrayList<>();
            client.add(cl);
			contrat.setClient(cl);;
		}
		
		 final Contrat updatecontrat=contratRepository.save(contrat);
	        return ResponseEntity.ok(updatecontrat);
	
}
//affecter un attribut a un contrat
public ResponseEntity<Contrat> affecterclientpdassuranceContratAttribut( int attributContratId,int contratId) throws ResourceNotFoundException {

	
	

    Contrat contrat = contratRepository.findById(contratId)
			.orElseThrow(() -> new ResourceNotFoundException("contrat not found for this id :: " + contratId));
    AttributContrat attributcontrat = attributcontratRepository.findById(attributContratId)
			.orElseThrow(() -> new ResourceNotFoundException("attributContrat not found for this id :: " + attributContratId));
	if(contrat.getAttributsContrat()==null)	{
    List<AttributContrat> atcontrat = new ArrayList<>();
			atcontrat.add(attributcontrat);
			contrat.setAttributsContrat(atcontrat);
	}else{
		contrat.getAttributsContrat().add(attributcontrat);
	}
		 final Contrat updatecontrat=contratRepository.save(contrat);
	        return ResponseEntity.ok(updatecontrat);
	
}
//trouver un contrat d'assurance avec produit id 
public ResponseEntity<Contrat> getContartByIdpdassurance(int pdassuranceId)
        throws ResourceNotFoundException {
    	Contrat contrat = contratByIdpdAssuranceRepository.findByIdAssurance(pdassuranceId);
        return ResponseEntity.ok().body(contrat);
    }

//trouver un contrat d'assurance avec client id 
public List<Contrat> getContratByIdClient(int clientId)
      throws ResourceNotFoundException {
	List<Contrat> contrats = contratByIdpdAssuranceRepository.findByIdClient(clientId);
	return contrats;
  	
     
  }
//trouver un contrat d'assurance  pour un partenaire d'asssurance findByIdPartenaireAssurance

public List<Contrat> findByIdPartenaireAssurance(int partenaireassuranceId)
	      throws ResourceNotFoundException {
		List<Contrat> contrats = contratByIdpdAssuranceRepository.findByIdPartenaireAssurance(partenaireassuranceId);
		return contrats;
	  	 }

}
