package com.rentersrank.dto;

import java.time.LocalDate;

import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.rentersrank.entity.Apartment;
import com.rentersrank.entity.Renter;

public class RenterDTO {
	
	private Integer renterId;
	@NotNull(message="{name.notpresent}")
//	@Pattern(regexp="/^[a-z ,.'-]+$/i", message="{name.invalid}")
	private String name;
	
	@Email(message="{email.invalid}")
	private String emailId;
	
//	@FutureOrPresent(message="date.present")
	private LocalDate move_inDate;
	@Future(message="date.future")
	private LocalDate move_outDate;

	private Integer apartmentId;
	
	public Integer getRenterId() {
		return renterId;
	}

	public void setRenterId(Integer renterId) {
		this.renterId = renterId;
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

	public LocalDate getMove_inDate() {
		return move_inDate;
	}

	public void setMove_inDate(LocalDate move_inDate) {
		this.move_inDate = move_inDate;
	}

	public LocalDate getMove_outDate() {
		return move_outDate;
	}

	public void setMove_outDate(LocalDate move_outDate) {
		this.move_outDate = move_outDate;
	}

	public Integer getApartmentId() {
		return apartmentId;
	}

	public void setApartmentId(Integer apartmentId) {
		this.apartmentId = apartmentId;
	}

	public static RenterDTO prepareDTO(Renter renter) {
		RenterDTO renterDTO = new RenterDTO();
//		renterDTO.setRenterId(renter.getRenterId());
//		renterDTO.setName(renter.getName());
//		renterDTO.setEmailId(renter.getEmailId());
		renterDTO.setMove_inDate(renter.getMove_inDate());
		renterDTO.setMove_outDate(renter.getMove_outDate());
//		ApartmentDTO apartmentDTO = ApartmentDTO.prepareDTO(renter.getApartment());
		renterDTO.setApartmentId(renter.getApartmentId());
		return renterDTO;
	}
	
	public static Renter populateEntity(RenterDTO renterDTO) {
		Renter renter = new Renter();
//		renter.setRenterId(renterDTO.getRenterId());
//		renter.setName(renterDTO.getName());
//		renter.setEmailId(renterDTO.getEmailId());
		renter.setMove_inDate(renterDTO.getMove_inDate());
		renter.setMove_outDate(renterDTO.getMove_outDate());
//		Apartment apartment = new Apartment();
//				ApartmentDTO.prepareEntity(renterDTO.getApartmentId());
		renter.setApartmentId(renterDTO.getApartmentId());
		return renter;
	}
}
