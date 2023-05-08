package com.rentersrank.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.rentersrank.dto.ApartmentDTO;
import com.rentersrank.dto.LandlordDTO;
import com.rentersrank.entity.Apartment;
import com.rentersrank.entity.Landlord;
import com.rentersrank.exception.RentersRankException;
import com.rentersrank.repository.ApartmentRepository;
import com.rentersrank.repository.LandlordRepository;

@Service(value="landlordService")
@Transactional
@Validated
public class LandlordServiceImpl implements LandlordService {

	@Autowired
	private LandlordRepository landlordRepository;
	@Autowired
	private ApartmentRepository apartmentRepository;
	
	@Override
	public List<LandlordDTO> getAllLandlords() throws RentersRankException {
		List<LandlordDTO> result = new ArrayList<>();
		for (Landlord l :landlordRepository.findAll()) {
			LandlordDTO landlordDTO = new LandlordDTO();
			if(l.getApartments().isEmpty()) {
				List<ApartmentDTO> aptDTOs = new ArrayList<>();
				landlordDTO.setApartments(aptDTOs);
			}
			result.add(LandlordDTO.prepareDTO(l));
		}
		return result;
		
	}

	@Override
	public LandlordDTO findLandLordByEmailId(String emailId) throws RentersRankException {
		if(landlordRepository.findLandLordByEmailId(emailId)==null)
			throw new RentersRankException("LandLord.Service.NO_SUCH_EMAILID");
		return LandlordDTO.prepareDTO(landlordRepository.findLandLordByEmailId(emailId)) ;
	}

	@Override
	public LandlordDTO addLandLord(LandlordDTO landLordDTO) throws RentersRankException {
		Landlord landlord = LandlordDTO.prepareEntity(landLordDTO);
		Set<Apartment> apartments = new HashSet();
		for(ApartmentDTO a : landLordDTO.getApartments()) {
			apartments.add(ApartmentDTO.prepareEntity(a));
		}
		landlord.setApartments(apartments);
		landlordRepository.save(landlord);
		LandlordDTO result = LandlordDTO.prepareDTO(landlord);
		return result;
	}

	@Override
	public List<ApartmentDTO> getListOfLandLordsApartments(Integer landLordId) throws RentersRankException {
		if (landlordRepository.findById(landLordId).isEmpty())
			throw new RentersRankException("LandLord.Service.NO_APARTMENTS");
		return landlordRepository.findApartmentsByLandlordId(landLordId);
//		return landlordRepository.getListOfLandLordsApartments(landLordId);
	}

	@Override
	public String deleteLandlord(Integer landlordId) throws RentersRankException {
		Optional<Landlord> optional = landlordRepository.findById(landlordId);
		Landlord landlord = optional.orElseThrow(() -> new RentersRankException("ApartmentService.APARTMENT_NOT_FOUND")); 
		
		Set<Apartment> apt = landlord.getApartments();
		for(Iterator<Apartment> iterator = apt.iterator(); iterator.hasNext();) {
			Apartment apartment = iterator.next();
			apartmentRepository.delete(apartment);
			iterator.remove();
		}
		landlordRepository.delete(landlord);
		return "Landlord with id " + landlordId + " has been removed from database";
	}

}
