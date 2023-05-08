package com.rentersrank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.rentersrank.dto.ApartmentDTO;
import com.rentersrank.entity.Apartment;
import com.rentersrank.exception.RentersRankException;
import com.rentersrank.repository.ApartmentRepository;

@Service(value="apartmentService")
@Transactional
@Validated
public class ApartmentServiceImpl implements ApartmentService {

	@Autowired
	private ApartmentRepository apartmentRepository;
	
	
	@Override
	public List<ApartmentDTO> getAllApartments() throws RentersRankException {
		List<ApartmentDTO> apartmentDTOs = new ArrayList<>();
		for(Apartment a : apartmentRepository.getAllApartments()) {
			apartmentDTOs.add(ApartmentDTO.prepareDTO(a));
		}
		return apartmentDTOs;
	}

	@Override
	public List<ApartmentDTO> getApartmentsByScore(Integer score) throws RentersRankException {
		List<ApartmentDTO> apartmentDTOs = new ArrayList<>();
		for(Apartment a : apartmentRepository.getApartmentsByScore(score)) {
			apartmentDTOs.add(ApartmentDTO.prepareDTO(a));
		}
		return apartmentDTOs;
	}

	@Override
	public List<ApartmentDTO> getAllVacantApartments() throws RentersRankException {
		List<ApartmentDTO> apartmentDTOs = new ArrayList<>();
		for(Apartment a : apartmentRepository.getAllVacantApartments()) {
			apartmentDTOs.add(ApartmentDTO.prepareDTO(a));
		}
		return apartmentDTOs;
	}
	
	@Override
	public Integer setScoreForApartment(Integer apartmentId, Integer score) throws RentersRankException {
		Optional<Apartment> optional = apartmentRepository.findById(apartmentId);
		Apartment apartment = optional.orElseThrow(() -> new RentersRankException("ApartmentService.APARTMENT_NOT_FOUND")); 
		apartment.setScore(score);
		apartmentRepository.save(apartment);
		return apartment.getScore();
	}

	@Override
	public String deleteApartment(Integer apartmentId) throws RentersRankException {
		Optional<Apartment> optional = apartmentRepository.findById(apartmentId);
		Apartment apartment = optional.orElseThrow(() -> new RentersRankException("ApartmentService.APARTMENT_NOT_FOUND")); 
		
//		Set<Apartment> apt = landlord.getApartments();
//		for(Iterator<Apartment> iterator = apt.iterator(); iterator.hasNext();) {
//			Apartment apartment = iterator.next();
//			iterator.remove();
//		}
		apartmentRepository.delete(apartment);
		return "Apartment with id " + apartmentId + " has been removed from database";
	}

//	@Override
//	public List<ApartmentDTO> getLandlordsApartments(Integer landlordId) throws RentersRankException {
//		List<ApartmentDTO> apartmentDTOs = new ArrayList<>();
//		for(Apartment a : apartmentRepository.findApartmentsByLandlordId(landlordId)) {
//			apartmentDTOs.add(ApartmentDTO.prepareDTO(a));
//		}
//		return apartmentDTOs;
//	}

}
