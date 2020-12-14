package com.jaune.JMlessous.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaune.JMlessous.model.Conge;
 
	@Repository
public interface CongeRepository extends JpaRepository<Conge, Integer>{
		

}
