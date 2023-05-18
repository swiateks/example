package com.rentersrank.api;

import java.time.LocalDate;
import java.util.*;

import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

import com.rentersrank.dto.LandlordDTO;
import com.rentersrank.dto.RenterDTO;
import com.rentersrank.entity.Landlord;
import com.rentersrank.exception.RentersRankException;
import com.rentersrank.service.RenterService;


@RestController 
@RequestMapping(value = "/renter")
@Validated
public class RenterController {
	@Autowired
	private Environment environment;
	@Autowired
	private RenterService renterService;
	
	@GetMapping(value="/getAll", produces = "application/json")
	public ResponseEntity<List<RenterDTO>> getAll() throws RentersRankException {
		List<RenterDTO> result = renterService.getRenters();
		return new ResponseEntity<>(result, HttpStatus.OK);   
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<String> addRenter(@Valid @RequestBody RenterDTO renterDTO) throws RentersRankException {
		String resp = renterService.addRenter(renterDTO);
		return new ResponseEntity<>(resp, HttpStatus.CREATED);
	
	}
	
	@GetMapping(value ="/{name}")
	public RenterDTO findByName(@PathVariable("name") String name) throws RentersRankException
	{
		return renterService.findRenterByName(name);
	}
	

	@GetMapping(value ="/{moveIn}/{moveOut}", produces = "application/json")
	public List<RenterDTO> findByDates(@RequestParam("moveIn") 
										@DateTimeFormat(pattern="MM-dd-yyyy") 
										@PastOrPresent(message="{api.renter.datenotvalid}")
										LocalDate moveIn, 
										@RequestParam("moveOut") 
										@DateTimeFormat(pattern="MM-dd-yyyy") 
										@FutureOrPresent(message="{api.renter.datenotvalid}")
										LocalDate moveOut) throws RentersRankException {
		return renterService.findByMoveInAndMoveOutDate(moveIn, moveOut);   
	}
	
	@DeleteMapping(value="/remove/{renterId}")
	public Integer deleteRenter(@PathVariable Integer renterId) throws RentersRankException {
		return renterService.deleteRenter(renterId);
	}
}
