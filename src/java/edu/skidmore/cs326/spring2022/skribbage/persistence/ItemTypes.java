package edu.skidmore.cs326.spring2022.skribbage.persistence;

/**
 * item types.
 * 
 * @author Tinaye Mawocha
 */
public enum ItemTypes {

    /**
     * list of item types with id numbers passed in as parameters to .
     */
    PARTY_HAT(001), BIRTHDAY_CAKE(002), MAGNIFYING_GLASS(003);

    /**
     * item ID.
     */
    @SuppressWarnings("unused")
    private int itemId;

    /**
     * itemTypes.
     * 
     * @param theItemId
     */
    ItemTypes(int theItemId) {
        this.itemId = theItemId;
    }

	public int getItemId() {
		return itemId;
	}

	
    
  
}
