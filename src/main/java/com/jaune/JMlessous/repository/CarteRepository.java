package com.jaune.JMlessous.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaune.JMlessous.model.Carte;

 
@Repository
public interface CarteRepository extends JpaRepository<Carte, Integer>{
}
