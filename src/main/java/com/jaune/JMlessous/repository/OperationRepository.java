package com.jaune.JMlessous.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jaune.JMlessous.model.CompteCourant;
import com.jaune.JMlessous.model.Operation;

 
@Repository
public interface OperationRepository extends JpaRepository<Operation, Integer>{
	@Query("SELECT o FROM Operation o  WHERE o.comptecourant.id =  ?1")
	List<Operation> findOpByCpt(int id);
	
	@Query("SELECT o FROM Operation o  WHERE o.statut =  ?1")
	List<Operation> findOpByStatut(String statut);
	
	@Query("SELECT o FROM Operation o  WHERE o.statut = :statut and o.comptecourant.id  = :id")
	List<Operation> findOpByCptStatut(
	  @Param("statut") String statut, 
	  @Param("id") int id);

}
