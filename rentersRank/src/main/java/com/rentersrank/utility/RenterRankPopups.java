package com.rentersrank.utility;


/**
 * The Enum ExceptionConstants.
 */

public enum RenterRankPopups {

	//Exception message constants
	RENTER_NOT_FOUND("Renter.RENTER_NOT_FOUND"), 
	RENTER_ALREADY_PRESENT("RenterService.RENTER_PRESENT"), 
	LANDLORD_NOT_FOUND("LandLord.RENTER_NOT_FOUND"),
	GENERAL_EXCEPTION_MESSAGE("general.exception"),
	
	
	//Success message constants
	RENTER_CREATE_SUCCESS("renter.create.success"),
	APARTMENT_UPDATE_SUCCESS("apartment.update.success"),
	RENTER_DELETE_SUCCESS("renter.delete.success");
	
	
	

	private final String type;

	private RenterRankPopups(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return this.type;
	}
}
