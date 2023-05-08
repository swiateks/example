package com.rentersrank.service;

import java.util.List;

import com.rentersrank.dto.ApartmentDTO;
import com.rentersrank.dto.LandlordDTO;
import com.rentersrank.entity.Landlord;
import com.rentersrank.exception.RentersRankException;

public interface LandlordService {

	public List<LandlordDTO> getAllLandlords() throws RentersRankException;
	
	public LandlordDTO findLandLordByEmailId(String emailId) throws RentersRankException;
	
	public LandlordDTO addLandLord(LandlordDTO landLordDTO) throws RentersRankException;
	
	public List<ApartmentDTO> getListOfLandLordsApartments(Integer landLordId) throws RentersRankException;

	public String deleteLandlord(Integer landlordId) throws RentersRankException;

}
