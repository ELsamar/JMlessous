package com.jaune.JMlessous.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jaune.JMlessous.model.Contrat;

@Repository
public interface ContratByIdpdAssuranceRepository extends ContratRepository {
	 @Query(value = "SELECT * FROM contrat WHERE produitassurance_id =:pdassuranceid", nativeQuery = true)
	 Contrat findByIdAssurance(@Param("pdassuranceid")int idpd);
	 @Query(value = "SELECT * FROM contrat WHERE client_id =:clientid", nativeQuery = true)
	 List<Contrat> findByIdClient(@Param("clientid")int idpd);
		 @Query(value = "SELECT * FROM contrat INNER JOIN produitassurance ON produitassurance.id=contrat.produitassurance_id WHERE produitassurance.employe_id=:partenaireAssuranceid ", nativeQuery = true)
	 List<Contrat> findByIdPartenaireAssurance(@Param("partenaireAssuranceid")int idpd);
///	 @Query(value = "SELECT * FROM contrat INNER JOIN produitassurance ON produitassurance.id=contrat.produitassurance_id WHERE produitassurance.employe_id=:partenaireAssuranceid ", nativeQuery = true)
	 
}
