package com.rentersrank.repository;

import java.util.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rentersrank.dto.ApartmentDTO;
import com.rentersrank.dto.LandlordDTO;
import com.rentersrank.dto.RenterDTO;
import com.rentersrank.entity.Landlord;
import com.rentersrank.entity.Renter;
import com.rentersrank.exception.RentersRankException;

@Repository(value = "LandlordRepository")
public interface LandlordRepository extends CrudRepository<Landlord, Integer> {
		
	
	@Query("select l from Landlord l")
	List<Landlord> findLandLords();
	
	@Query("select l from Landlord l where l.emailId= :emailId")
	Landlord findLandLordByEmailId(@Param("emailId") String emailId);
	
	@Query(value="SELECT a.address FROM Apartment a LEFT JOIN Landlord l ON a.apartment_id = l.apartment_id WHERE l.landlord_id= :landlordId" , nativeQuery = true)
	List<ApartmentDTO> getListOfLandLordsApartments(@Param("landlordId") Integer landlordId);
	
	List<ApartmentDTO> findApartmentsByLandlordId(Integer landlordId);
//	apartment_id,address,occupied_from,occupied_to,rent,score,status
}
