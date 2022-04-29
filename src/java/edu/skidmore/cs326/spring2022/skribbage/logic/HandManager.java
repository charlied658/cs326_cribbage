package edu.skidmore.cs326.spring2022.skribbage.logic;

import edu.skidmore.cs326.spring2022.skribbage.common.Card;

import edu.skidmore.cs326.spring2022.skribbage.common.Hand;

/**
 * Contains methods to manipulate the hand. These methods can
 * add a card to a Hand, or remove a card from the hand.
 * 
 * @author Dorjee W.
 */
public class HandManager implements HandManagement {

    /**
     * Adding a card to hand. Validity of card is already checked by card class.
     * 
     * @param hand
     *            the hand to which the card will be added to.
     * @param card
     *            card that will be added to the hand.
     */
    public void addCardToHand(Hand hand, Card card) {
        hand.addCard(card);

    }

    /**
     * Get the index of the card to be removed, and removes it from the
     * specified hand.
     * 
     * @param hand
     *            the hand the card will be removed from.
     * @param card
     *            the card to be removed.
     * @return Card the card to be removed is returned.
     */
    public Card removeCardFromHand(Hand hand, Card card) {
        return hand.removeCard(card);

    }

}
