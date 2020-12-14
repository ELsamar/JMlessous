package com.jaune.JMlessous.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaune.JMlessous.model.ProduitAssurance;

	@Repository
public interface ProduitAssuranceRepository extends JpaRepository<ProduitAssurance, Integer>{

}
