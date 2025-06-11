package com.pzfomar.springbase.core.enums;

/**
 * The Enum CollectionEnum.
 */
public enum CollectionEnum {

	/** The base. */
	BASE("base"),;

	/** The value. */
	private String value;

	/**
	 * Instantiates a new collection enum.
	 *
	 * @param value the value
	 */
	CollectionEnum(String value) {
		this.value = value;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return this.value;
	}
}
