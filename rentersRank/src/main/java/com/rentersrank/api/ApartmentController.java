package com.rentersrank.api;

import java.util.List;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentersrank.dto.ApartmentDTO;
import com.rentersrank.exception.RentersRankException;
import com.rentersrank.service.ApartmentServiceImpl;

@RestController
@RequestMapping(value = "/apartment")
@Validated
public class ApartmentController {

	@Autowired
	private ApartmentServiceImpl apartmentService;
	
	@GetMapping(value="/getAll", produces = "application/json")
	public ResponseEntity<List<ApartmentDTO>> getAll() throws RentersRankException {
		List<ApartmentDTO> result = apartmentService.getAllApartments();
		return new ResponseEntity<>(result, HttpStatus.OK);   
	}
	
	@GetMapping(value="/byScore/{score}", produces = "application/json")
	public ResponseEntity<List<ApartmentDTO>> getByScore(@PathVariable("score")
	 													@Min(0) @Max(5) Integer score) throws RentersRankException {
		List<ApartmentDTO> result = apartmentService.getApartmentsByScore(score);
		return new ResponseEntity<>(result, HttpStatus.OK);   
	}

	@GetMapping(value="/getVacant", produces = "application/json")
	public ResponseEntity<List<ApartmentDTO>> getVacant() throws RentersRankException {
		List<ApartmentDTO> result = apartmentService.getAllVacantApartments();
		return new ResponseEntity<>(result, HttpStatus.OK);   
	}
	
	@DeleteMapping(value="/remove/{apartmentId}")
	public String deleteApartment(@PathVariable Integer apartmentId) throws RentersRankException {
		return apartmentService.deleteApartment(apartmentId);
	}
	
//	@GetMapping(value="/byLandlord", produces = "application/json")
//	public ResponseEntity<List<ApartmentDTO>> getByLandlord() throws RentersRankException {
//		List<ApartmentDTO> result = apartmentService.getAllVacantApartments();
//		return new ResponseEntity<>(result, HttpStatus.OK);   
//	}
	
	// ADD, SET SCORE AND DELETE METHODS COMING
}
