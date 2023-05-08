package com.rentersrank.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.validation.Constraint;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.rentersrank.entity.Apartment;
import com.rentersrank.entity.Landlord;
import com.rentersrank.validator.EventValidator;


public class LandlordDTO {

	private Integer landlordId;
	@NotNull(message="{name.notpresent}")
	@Pattern(regexp="[A-Za-z]+", message="{name.invalid}")
	private String name;
	
	@NotNull(message="{entity.isempty}")
	@Email(message="{email.invalid}")
	private String emailId;
	
	@NotNull(message="{apartment.notpresent}")
	private List<ApartmentDTO> apartments;
	
	
	public Integer getLandLordId() {
		return landlordId;
	}
	public void setLandLordId(Integer landLordId) {
		this.landlordId = landLordId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}	
	public List<ApartmentDTO> getApartments() {
		return apartments;
	}
	public void setApartments(List<ApartmentDTO> apartments) {
		this.apartments = apartments;
	}
	
	public static Landlord prepareEntity(LandlordDTO landLordDTO) {
		Landlord landLord = new Landlord();
		landLord.setLandlordId(landLordDTO.getLandLordId());
		landLord.setName(landLordDTO.getName());
		landLord.setEmailId(landLordDTO.getEmailId());
		Set<Apartment> apartments = new HashSet(); 
		for(ApartmentDTO a : landLordDTO.getApartments()) {
			apartments.add(ApartmentDTO.prepareEntity(a));
		}
		landLord.setApartments(apartments);
		return landLord;	
	}
	
	public static LandlordDTO prepareDTO(Landlord landLord) {
		LandlordDTO landLordDTO = new LandlordDTO();
		landLordDTO.setLandLordId(landLord.getLandlordId());
		landLordDTO.setName(landLord.getName());
		landLordDTO.setEmailId(landLord.getEmailId());
		List<ApartmentDTO> apartmentDTOs = new LinkedList<>();
		if(!landLord.getApartments().isEmpty()) {
			for(Apartment a : landLord.getApartments()) {
				apartmentDTOs.add(ApartmentDTO.prepareDTO(a));
			}
		}
		landLordDTO.setApartments(apartmentDTOs);
		return landLordDTO;
	}

	
	
}
