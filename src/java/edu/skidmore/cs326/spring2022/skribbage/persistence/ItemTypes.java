package edu.skidmore.cs326.spring2022.skribbage.persistence;

public enum ItemTypes {

	PARTY_HAT(001), BIRTHDAY_CAKE(002), MAGNIFYING_GLASS(003);

	private int itemId;

	private ItemTypes(int theItemId) {
		this.itemId = theItemId;
	}

}
