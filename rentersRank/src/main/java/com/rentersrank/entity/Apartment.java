package com.rentersrank.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Apartment {
	
	@Id
	@GeneratedValue(generator="pkgen",strategy=GenerationType.TABLE)
	@TableGenerator(
            name="pkgen", 
            table="id_gen", 
            pkColumnName="gen_key", 
            valueColumnName="gen_value",
            pkColumnValue="apartment_id",
            initialValue = 1000,
            allocationSize=1
            )
	private Integer apartmentId;
	private String address;
	private LocalDate occupied_from;
	private LocalDate occupied_to;
	private Integer rent;
	private Integer score;
	private boolean status;
	
	
	public Integer getApartmentId() {
		return apartmentId;
	}
	public void setApartmentId(Integer apartmentId) {
		this.apartmentId = apartmentId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String adress) {
		this.address = adress;
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
	@Override
	public String toString() {
		return "Apartment [apasrtmentId=" + apartmentId + "]";
	}
	
}
