package com.robertojr.PROJECT_API_REST.entities.enums;

public enum HistoryStatus {
	
	COMPLETED(1), CANCELLED(2);

	private int code;

	private HistoryStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static HistoryStatus valueOfCode(int code) {
		for (HistoryStatus item : HistoryStatus.values()) {
			if (code == item.getCode()) {
				return item;
			}
		}
		throw new IllegalArgumentException("Invalid HistoryStatus code: "+code);
	}

}
