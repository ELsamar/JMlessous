package com.jaune.JMlessous.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaune.JMlessous.model.Cheque;

 
@Repository
public interface ChequeRepository extends JpaRepository<Cheque, Integer>{
}
