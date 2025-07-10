package com.robertojr.PROJECT_API_REST.entities.enums;

public enum Available {

	ONLINE(1), OFFLINE(2), UNDEFINED(0);

	private int code;

	private Available(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static Available valueOfCode(int code) {
		for (Available item : Available.values()) {
			if (code == item.getCode()) {
				return item;
			}
		}
		throw new IllegalArgumentException("Invalid Available code: "+code);
	}
	
	
	
	
	
}
