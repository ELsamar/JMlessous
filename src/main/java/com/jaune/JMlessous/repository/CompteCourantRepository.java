package com.jaune.JMlessous.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.jaune.JMlessous.model.CompteCourant;;


	@Repository
public interface CompteCourantRepository extends JpaRepository<CompteCourant, Integer>{

		@Query("SELECT c FROM CompteCourant c  WHERE c.client.id =  ?1")
		List<CompteCourant> findCptByClient(int id);
		@Query("SELECT c FROM CompteCourant c  WHERE c.rip =  ?1")
		CompteCourant findCptByRip(int id);

}
