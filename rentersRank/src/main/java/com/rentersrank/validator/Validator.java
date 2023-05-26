package com.rentersrank.validator;

import java.time.LocalDate;

import org.w3c.dom.events.EventException;

import com.rentersrank.dto.*;
import com.rentersrank.exception.RentersRankException;

public class Validator {

	private Validator() {
		
	}
	
	public static void validateRent(RenterDTO renterDTO) throws RentersRankException {
		if (!isValidMoveInDate(renterDTO.getMove_inDate())) {
			throw new RentersRankException("RentValidator.INVALID_MOVEIN_DATE");
		}
	}
	
	public static Boolean isValidMoveInDate(LocalDate moveInDate) {
		return moveInDate.isAfter(LocalDate.now()) ? true : false;
	}	
}
