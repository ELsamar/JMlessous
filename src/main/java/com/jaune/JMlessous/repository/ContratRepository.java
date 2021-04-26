package com.jaune.JMlessous.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaune.JMlessous.model.Contrat;
@Repository
public interface ContratRepository  extends JpaRepository<Contrat, Integer>{
}
