package com.robertojr.PROJECT_API_REST.services.exceptions;

public class IlegalArgumentException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public IlegalArgumentException() {

	}

	public IlegalArgumentException(String msg) {
		super("Error! Ilegal Argument! caused by:"+msg);
	}

	public IlegalArgumentException(String msg, Integer id) {
		super("Error! Ilegal Argument! caused by: "+msg+" id:"+id);
	}
}
