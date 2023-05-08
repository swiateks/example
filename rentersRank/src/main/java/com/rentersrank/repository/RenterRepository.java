package com.rentersrank.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rentersrank.dto.RenterDTO;
import com.rentersrank.entity.Renter;



@Repository(value = "RenterRepository")
public interface RenterRepository extends CrudRepository<Renter, Integer> {

	
	
	Optional<Renter> findByName(String name);
	
	@Query("SELECT r FROM Renter r WHERE r.name= :name")
	Renter findEventByName(@Param("name") String name);
	
	@Query("select r from Renter r where r.move_inDate < :move_inDate and r.move_outDate > :move_outDate")
	List<Renter> findByMoveInAndMoveOutDate(@Param("move_inDate") LocalDate moveIn, @Param("move_outDate") LocalDate moveOut);

	Optional<Renter> findByEmailId(String emailId);
}

