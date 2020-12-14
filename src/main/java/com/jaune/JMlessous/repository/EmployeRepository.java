package com.jaune.JMlessous.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.jaune.JMlessous.model.Employe;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Integer>{

}
