package com.robertojr.PROJECT_API_REST.entities.enums;

public enum AvailableDriver {

	ONLINE(1), OFFLINE(2), UNDEFINED(0);

	private int code;

	private AvailableDriver(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static AvailableDriver valueOfCode(int code) {
		for (AvailableDriver item : AvailableDriver.values()) {
			if (code == item.getCode()) {
				return item;
			}
		}
		throw new IllegalArgumentException("Invalid AvailableDriver code: "+code);
	}
	
	
	
	
	
}
