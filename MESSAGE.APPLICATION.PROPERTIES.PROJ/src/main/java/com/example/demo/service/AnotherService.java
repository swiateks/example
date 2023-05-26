package com.example.demo.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class AnotherService {
	 String city;
	 String street;
	 
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
}
