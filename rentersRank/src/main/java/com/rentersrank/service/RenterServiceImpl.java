package com.rentersrank.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;


import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.rentersrank.dto.LandlordDTO;
import com.rentersrank.dto.RenterDTO;
import com.rentersrank.entity.Apartment;
import com.rentersrank.entity.Landlord;
import com.rentersrank.entity.Renter;
import com.rentersrank.exception.RentersRankException;
import com.rentersrank.repository.ApartmentRepository;
import com.rentersrank.repository.LandlordRepository;
import com.rentersrank.repository.RenterRepository;
import com.rentersrank.utility.RenterRankPopups;
import com.rentersrank.validator.EventValidator;


@Service(value="eventServiceImpl")
@Transactional
@Validated
@PropertySource("classpath:UserMessages.properties")
public class RenterServiceImpl implements RenterService {
	
	@Autowired
	private RenterRepository renterRepository;
	@Autowired
	private LandlordRepository landLordRepository;
	@Autowired
	private ApartmentRepository apartmentRepository;
	@Autowired
	private Environment environment;
	
	
	@Override
	public List<RenterDTO> getRenters() throws RentersRankException {
		List<RenterDTO> results = new ArrayList<>();
		for (Renter r : renterRepository.findAll()) {
			results.add(RenterDTO.prepareDTO(r));
		}
		if(results.isEmpty())
			throw new RentersRankException("RenterService.RENTER_UNAVAILABLE");
		return results;
	}


	@Override
	public String addRenter(RenterDTO renterDTO) throws RentersRankException {
		Optional<Renter> optional = renterRepository.findByEmailId(renterDTO.getEmailId());
		if (optional.isPresent()) {
			throw new RentersRankException("RenterService.RENTER_PRESENT");
		}
		Optional<Apartment> optionalApt = apartmentRepository.findById(renterDTO.getApartmentId());
		Apartment desired = optionalApt.orElseThrow(()-> new RentersRankException("ApartmentService.APARTMENT_NOT_FOUND"));
		if(desired.isStatus()==true) {
			throw new RentersRankException("RenterService.APARTMENT_UNAVAILABLE");
		}
		Renter renter = RenterDTO.populateEntity(renterDTO);
		renterRepository.save(renter);
		desired.setStatus(false);
		return environment.getProperty(RenterRankPopups.RENTER_CREATE_SUCCESS.toString());
	}


	@Override
	public RenterDTO findRenterByName(String name) throws RentersRankException {
		Optional<Renter> optional = renterRepository.findByName(name);
		Renter renter = optional.orElseThrow(()-> 
		new RentersRankException(environment.getProperty(RenterRankPopups.RENTER_ALREADY_PRESENT.toString())));
		return RenterDTO.prepareDTO(renter);
	}


	@Override
	public List<RenterDTO> findByMoveInAndMoveOutDate(LocalDate moveIn, LocalDate moveOut) throws RentersRankException {
		List<Renter> list = renterRepository.findByMoveInAndMoveOutDate(moveIn, moveOut);
		List<RenterDTO> DTOlist = new ArrayList<>();
		if (list.isEmpty())
			throw new RentersRankException(environment.getProperty(RenterRankPopups.RENTER_NOT_FOUND.toString()));
		for (Renter r : list) {
			DTOlist.add(RenterDTO.prepareDTO(r));
		}
		return DTOlist;
	}

	@Override
	public Integer deleteRenter(Integer renterId) throws RentersRankException {
		 Optional<Renter> optional = renterRepository.findById(renterId);
		 Renter renter = optional.orElseThrow(()-> new RentersRankException("Renter.RENTER_NOT_FOUND"));
		 renterRepository.delete(renter);
		 return renterId;
	}
}