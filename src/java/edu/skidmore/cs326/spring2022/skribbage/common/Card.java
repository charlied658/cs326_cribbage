package edu.skidmore.cs326.spring2022.skribbage.common;

/**
 * Java bean for all data associated with a card.
 * In combination with Rank and Suit, replaces old Card class seen in Logic
 * package.
 * 
 * @author Declan Morris
 */
public class Card {

    /**
     * The enum value representing the card's suit (hearts, clubs, etc).
     */
    private Suit suit;

    /**
     * The enum value representing the card's rank (ace, two, etc).
     */
    private Rank rank;

    /**
     * ID of the card.
     */
    private int cardID;
    
    /**
     * Allows other classes to access the card's suit.
     * 
     * @return suit.
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Allows other classes to access the card's rank.
     * 
     * @return rank.
     */
    public Rank getRank() {
        return rank;
    }
    
    /**
     * Get the card ID.
     * @return cardID
     */
    public int getCardID() {
        return this.cardID;
    }
    
    /**
     * Set the cardID.
     * @param cardID card ID integer
     */
    public void setCardID(int cardID) {
        this.cardID = cardID;
    }

    /**
     * Constructor sets appropriate values for a new card.
     * 
     * @param suit suit enum
     * @param c rank of the card
     */
    public Card(Rank c, Suit suit) {
        this.suit = suit;
        this.rank = c;
        //Num_rank x suit + rank = cardID
        this.cardID = (13 * this.suit.ordinal()) + this.rank.ordinal();
    }

    /**
     * Compares the rank and suit of two cards.
     * 
     * @return boolean
     * @param tempCard card to compare for equality
     */
    @Override
    public boolean equals(Object tempCard) {
        if (tempCard instanceof Card) {
            return this.getRank() == ((Card) tempCard).getRank()
                && this.getSuit() == ((Card) tempCard).getSuit();
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (this.getRank() + " " + this.getSuit()).hashCode();
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("Card{");
        sb.append("suit=").append(suit);
        sb.append(", rank=").append(rank);
        sb.append(", cardID=").append(cardID);
        sb.append('}');
        return sb.toString();
    }
}
