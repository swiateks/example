package com.rentersrank.exception;

import org.springframework.http.HttpStatus;

public class RentersRankException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public RentersRankException(String message) {
		super(message);
	}

	public RentersRankException(HttpStatus notFound, String message, Exception e) {
		// TODO Auto-generated constructor stub
	}

}
