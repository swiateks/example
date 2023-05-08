package com.rentersrank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rentersrank.dto.ApartmentDTO;
import com.rentersrank.entity.Apartment;

public interface ApartmentRepository extends CrudRepository<Apartment, Integer> {
	
	@Query("SELECT a FROM Apartment a")
	List<Apartment> getAllApartments();
	
	@Query("SELECT a FROM Apartment a WHERE a.score = :score")
	List<Apartment> getApartmentsByScore(@Param("score") Integer score);
	
	@Query("SELECT a FROM Apartment a WHERE a.status = 0")
	List<Apartment> getAllVacantApartments();
	
}
