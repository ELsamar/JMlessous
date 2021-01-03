package com.jaune.JMlessous.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaune.JMlessous.model.CarnetCheque;

 
@Repository
public interface CarnetChequeRepository extends JpaRepository<CarnetCheque, Integer>{
}
