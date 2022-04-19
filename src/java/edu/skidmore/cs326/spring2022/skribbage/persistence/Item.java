package edu.skidmore.cs326.spring2022.skribbage.persistence;

public class Item {
	
	
	private ItemTypes itemType;
	
	private int quantityHeld;
	

	public ItemTypes getItemType() {
		return itemType;
	}



	public void setItemType(ItemTypes itemType) {
		this.itemType = itemType;
	}



	public int getQuantityHeld() {
		return quantityHeld;
	}



	public void setQuantityHeld(int quantityHeld) {
		this.quantityHeld = quantityHeld;
	}



	public String toString() {
		return "";
	}

}
