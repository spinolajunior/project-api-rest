package com.robertojr.PROJECT_API_REST.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object id) {
		super("Resouce not found Id: " + id);
	}

	public ResourceNotFoundException(Object id,String msg) {
		super(msg+":Resouce not found Id:" + id);
	}
}
