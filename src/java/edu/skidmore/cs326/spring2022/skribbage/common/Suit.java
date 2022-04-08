package edu.skidmore.cs326.spring2022.skribbage.common;

/**
 * enum for suit.
 * 
 * TODO (DSR): Lets talk through the design of Card, Hand, Deck...

 * 
 * @author Declan Morris
 */
public enum Suit {
    /**
     * Hearts suit.
     */
    HEARTS("Hearts"),
    /**
     * Clubs suit.
     */
    CLUBS("Clubs"),
    /**
     * Diamonds suit.
     */
    DIAMONDS("Diamonds"),
    /**
     * Spades suit.
     */
    SPADES("Spades");
    
    /**
     * The name of the suit in string form.
     */
    private String name;
    
    /**
     * Constructor that provides each suit with a String value of its name.
     * @param name
     */
    Suit(String name) {
        this.name = name;
    }
    
    /**
     * Allows other classes access to name attribute.
     * @return name
     */
    public String getName() {
        return name;
    }
}
