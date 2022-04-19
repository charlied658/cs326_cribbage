package edu.skidmore.cs326.spring2022.skribbage.persistence;

/**
 * item class.
 * 
 * @author Tinaye Mawocha
 */
public class Item {

    /**
     * itemtype.
     */
    private ItemTypes itemType;

    /**
     * quantity held.
     */
    private int quantityHeld;

    /**
     * getItem type.
     * 
     * @return type.
     */
    public ItemTypes getItemType() {
        return itemType;
    }

    /**
     * setITem type.
     * 
     * @param itemType
     */
    public void setItemType(ItemTypes itemType) {
        this.itemType = itemType;
    }

    /**
     * getQuantityHeld.
     * 
     * @return quantity.
     */
    public int getQuantityHeld() {
        return quantityHeld;
    }

    /**
     * setQuantityHeld.
     * 
     * @param quantityHeld
     */
    public void setQuantityHeld(int quantityHeld) {
        this.quantityHeld = quantityHeld;
    }

    /**
     * toString.
     * 
     * @return the string.
     */
    public String toString() {
        return "item type: " + itemType + "\nquantity held: " + quantityHeld;
    }

}
