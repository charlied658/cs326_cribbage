package edu.skidmore.cs326.spring2022.skribbage.common;

import java.util.ArrayList;

/**
 * Hand Class representing the methods.
 * TODO (DSR): Lets talk through the design of Card, Hand, Deck...
 *
 * @author Dorjee
 *         Last Edited: Dorjee
 */
public class Hand {

    /**
     * Creating variable hand to hold a players cards.
     */
    private ArrayList<Card> hand;

    /**
     * Constructor for Hand that initializes an ArrayList of Cards.
     */
    public Hand() {

        hand = new ArrayList<Card>();

    }

    /**
     * Adding a card to hand. Validity of card is already checked by card class.
     *
     * @param card
     *            to add
     */
    public void addCardToHand(Card card) {
        hand.add(card);
    }

    /**
     * Call to remove a card from a players hand.
     *
     * @param card
     *            the card to be removed from hand.
     */
    public void removeCardFromHand(Card card) {
        hand.remove(card);
    }

    /**
     * Get method to return an arrayList of a players current cards.
     *
     * @return Hand the players current hand
     */
    public ArrayList<Card> getHand() {
        return hand;
    }

}
