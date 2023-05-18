package com.rentersrank.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.rentersrank.dto.RenterDTO;

@Entity
public class Renter 
//extends User implements Serializable 
{
	@Id
	@GeneratedValue(generator="pkgen",strategy=GenerationType.TABLE)
	@TableGenerator(
            name="pkgen", 
            table="id_gen", 
            pkColumnName="gen_key", 
            valueColumnName="gen_value",
            pkColumnValue="renter_id",
            initialValue = 1,
            allocationSize=1
            )
	private Integer renterId;
	
	private String name;
	
	private String emailId;
	
	@Column(name="moveIn_date")
	private LocalDate move_inDate;
	@Column(name="moveOut_date")
	private LocalDate move_outDate;
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="apartmentId")
//	private Apartment apartment;
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

}