package com.rentersrank.api;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentersrank.dto.ApartmentDTO;
import com.rentersrank.dto.LandlordDTO;
import com.rentersrank.entity.Landlord;
import com.rentersrank.exception.RentersRankException;
import com.rentersrank.service.LandlordService;

@RestController
@RequestMapping(value = "/landlord")
@Validated
public class LandlordController {
	@Autowired
	private LandlordService landlordService;
	
	@GetMapping(value="/getAll", produces = "application/json")
	public ResponseEntity<List<LandlordDTO>> getAll() throws RentersRankException {
		List<LandlordDTO> result = landlordService.getAllLandlords();
		return new ResponseEntity<>(result, HttpStatus.OK);   
	}
	
	@GetMapping(value="/{emailId}", produces = "application/json")
	public ResponseEntity<LandlordDTO> findByEmail(@PathVariable("emailId")
														@Email(message="{email.invalid}")
														String emailId) throws RentersRankException {
		LandlordDTO result = landlordService.findLandLordByEmailId(emailId);
		return new ResponseEntity<>(result, HttpStatus.OK);   
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<LandlordDTO> addLandLord(@Valid @RequestBody LandlordDTO landLordDTO) throws RentersRankException {
		LandlordDTO resp = landlordService.addLandLord(landLordDTO);
		return new ResponseEntity<>(resp, HttpStatus.CREATED);
	}
	
	
	////nie działa
	@GetMapping(value="/getApartments/{landLordId}", produces = "application/json")
	public ResponseEntity<List<ApartmentDTO>> getApartments(@PathVariable("landLordId") Integer landLordId) throws RentersRankException {
		List<ApartmentDTO> result = landlordService.getListOfLandLordsApartments(landLordId);
		return new ResponseEntity<>(result, HttpStatus.OK);   
	}
	
	@DeleteMapping(value="/remove/{landlordId}")
	public String deleteLandlord(@PathVariable Integer landlordId) throws RentersRankException {
		return landlordService.deleteLandlord(landlordId);
	}
	
}
