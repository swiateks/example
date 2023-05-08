package com.rentersrank.service;

import java.util.List;

import com.rentersrank.dto.ApartmentDTO;
import com.rentersrank.entity.Apartment;
import com.rentersrank.exception.RentersRankException;

public interface ApartmentService {

	public List<ApartmentDTO> getAllApartments() throws RentersRankException;
	public List<ApartmentDTO> getApartmentsByScore(Integer score) throws RentersRankException;
	public List<ApartmentDTO> getAllVacantApartments() throws RentersRankException;
	public Integer setScoreForApartment(Integer apartmentId, Integer score)  throws RentersRankException;
	public String deleteApartment(Integer apartmentId) throws RentersRankException;
//	public List<ApartmentDTO> getLandlordsApartments(Integer landlordId) throws RentersRankException;
	
}
