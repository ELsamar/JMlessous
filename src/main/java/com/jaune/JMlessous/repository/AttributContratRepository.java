package com.jaune.JMlessous.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jaune.JMlessous.model.AttributContrat;

@Repository
public interface AttributContratRepository extends JpaRepository<AttributContrat, Integer> {

}
