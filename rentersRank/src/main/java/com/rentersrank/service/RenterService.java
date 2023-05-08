package com.rentersrank.service;

import java.time.LocalDate;
import java.util.*;
import javax.validation.Valid;
import com.rentersrank.dto.*;
import com.rentersrank.entity.Landlord;
import com.rentersrank.exception.*;

public interface RenterService {
	
	public List<RenterDTO> getRenters() throws RentersRankException;
	
	public String addRenter(RenterDTO renterDTO) throws RentersRankException;
	
	
	public RenterDTO findRenterByName(String name) throws RentersRankException;
	
	//for finding renters with date of moving in and out between the ranges
	public List<RenterDTO> findByMoveInAndMoveOutDate(LocalDate moveIn, LocalDate moveOut) throws RentersRankException;
	
	public Integer deleteRenter(Integer renterId) throws RentersRankException;
}
