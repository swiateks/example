package com.rentersrank.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.rentersrank.entity.Apartment;

public class ApartmentDTO {

	private Integer apartmentId;
	
	@NotNull(message="{address.notpresent}")
	private String address;
	@DateTimeFormat(pattern = "dd.MM.yyyy")
	private LocalDate occupied_from;
	
	@DateTimeFormat(pattern = "dd.MM.yyyy")
	private LocalDate occupied_to;
	
	private Integer rent;
	@Size(max=5,min=0, message="{Score must be a number from 0-5}")
	private Integer score;
	@NotNull(message="{apartment.status.notpresent}")
	private boolean status;
	
	public Integer getApartmentId() {
		return apartmentId;
	}
	public void setApartmentId(Integer apasrtmentId) {
		this.apartmentId = apasrtmentId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDate getOccupied_from() {
		return occupied_from;
	}
	public void setOccupied_from(LocalDate occupied_from) {
		this.occupied_from = occupied_from;
	}
	public LocalDate getOccupied_to() {
		return occupied_to;
	}
	public void setOccupied_to(LocalDate occupied_to) {
		this.occupied_to = occupied_to;
	}
	public Integer getRent() {
		return rent;
	}
	public void setRent(Integer rent) {
		this.rent = rent;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public static Apartment prepareEntity(ApartmentDTO apartmentDTO) {
		Apartment apartment = new Apartment();
		apartment.setApartmentId(apartmentDTO.getApartmentId());
		apartment.setAddress(apartmentDTO.getAddress());
		apartment.setOccupied_from(apartmentDTO.getOccupied_from());
		apartment.setOccupied_to(apartmentDTO.getOccupied_to());
		apartment.setRent(apartmentDTO.getRent());
		apartment.setScore(apartmentDTO.getScore());
		apartment.setStatus(apartmentDTO.isStatus());
		return apartment;
	}
	public static ApartmentDTO prepareDTO(Apartment apartment) {
		ApartmentDTO apartmentDTO = new ApartmentDTO();
		apartmentDTO.setApartmentId(apartment.getApartmentId());
		apartmentDTO.setAddress(apartment.getAddress());
		apartmentDTO.setOccupied_from(apartment.getOccupied_from());
		apartmentDTO.setOccupied_to(apartment.getOccupied_to());
		apartmentDTO.setRent(apartment.getRent());
		apartmentDTO.setScore(apartment.getScore());
		apartmentDTO.setStatus(apartment.isStatus());
		return apartmentDTO;
	}

}
