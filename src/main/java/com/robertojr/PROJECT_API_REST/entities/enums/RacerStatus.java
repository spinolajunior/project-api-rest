package com.robertojr.PROJECT_API_REST.entities.enums;

public enum RacerStatus {
	
	ACTIVE(1), COMPLETED(2), CANCELLED(0);

	private int code;

	private RacerStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static RacerStatus valueOfCode(int code) {
		for (RacerStatus item : RacerStatus.values()) {
			if (code == item.getCode()) {
				return item;
			}
		}
		throw new IllegalArgumentException("Invalid RacerStatus code: "+code);
	}

}
