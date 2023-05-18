package com.rentersrank.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

//@IdClass(com.rentersrank.entity.User.class)  
@Entity
@Table(name = "landlord")
public class Landlord 
//extends User implements Serializable 
{

	@Id	
	@GeneratedValue(generator="pkgen",strategy=GenerationType.TABLE)
	@TableGenerator(
            name="pkgen", 
            table="id_gen", 
            pkColumnName="gen_key", 
            valueColumnName="gen_value",
            pkColumnValue="landlord_id",
            initialValue = 100,
            allocationSize=1
            )

	private Integer landlordId;
	private String name;
	private String emailId;
	@OneToMany(cascade=CascadeType.REMOVE)
//	@JoinColumn(name="apartmentId")
	private Set<Apartment> apartments;
	
	public Integer getLandlordId() {
		return landlordId;
	}
	public void setLandlordId(Integer landlordId) {
		this.landlordId = landlordId;
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
	public Set<Apartment> getApartments() {
		return apartments;
	}
	public void setApartments(Set<Apartment> apartments) {
		this.apartments = apartments;
	}	
}
