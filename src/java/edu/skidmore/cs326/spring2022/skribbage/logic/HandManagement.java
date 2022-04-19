package edu.skidmore.cs326.spring2022.skribbage.logic;

import edu.skidmore.cs326.spring2022.skribbage.common.Card;
import edu.skidmore.cs326.spring2022.skribbage.common.Hand;

/**
 * Interface for HandManager.
 * 
 * @author Dorjee W.
 */

interface HandManagement {
    /**
     * Adding a card to hand. Validity of card is already checked by card class.
     * 
     * @param hand
     *            the hand to which the card will be added to.
     * @param card
     *            card that will be added to the hand.
     */
    void addCardToHand(Hand hand, Card card);

    /**
     * Get the index of the card to be removed, and removes it from the
     * specified hand.
     * 
     * @param hand
     *            the hand the card will be removed from.
     * @param index
     *            the index of the card to be removed.
     */
    void removeCardFromHand(Hand hand, int index);

}
