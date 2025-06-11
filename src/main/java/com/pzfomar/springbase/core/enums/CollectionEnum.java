package com.pzfomar.springbase.core.enums;

public enum CollectionEnum {
	BASE("base"),;

	private String value;

	CollectionEnum(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}
}
