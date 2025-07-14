package com.robertojr.PROJECT_API_REST.services.exceptions;

public class DataBaseException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public DataBaseException(Long id) {
	super("Data base Error Id: "+id);
	}

}
