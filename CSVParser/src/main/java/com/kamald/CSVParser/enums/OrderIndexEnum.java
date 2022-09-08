package com.kamald.CSVParser.enums;

public enum OrderIndexEnum {
	ORDER_ID(0),
	AMOUNT(1),
	CURRENCY(2),
	COMMENT(3);
	
	int index;
	OrderIndexEnum(int index) {
		this.index = index;
	}
	
	public int getIndex() {
		return this.index;
	}
}
