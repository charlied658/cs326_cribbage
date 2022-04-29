package edu.skidmore.cs326.spring2022.skribbage.common;

import java.util.ArrayList;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Bean class for Hand, that contains a constructor for the Hand, and
 * a set and get method.
 *
 * @author Dorjee
 *         Last Edited: Dorjee
 */
public class Hand {

    /**
     * Private static final instance of a Logger for this class.
     */
    private static final Logger LOG;
    /**
     * Static block.
     */
    static {

        LOG = Logger.getLogger(Hand.class);
    }

    /**
     * Creating variable hand to hold a players cards.
     */
    private List<Card> cardsInHand = new ArrayList<Card>();

    /**
     * Constructor for Hand that initializes an ArrayList of Cards.
     */
    public Hand() {

        cardsInHand = new ArrayList<Card>();

    }

    /**
     * adds a card to the end of the hand.
     * 
     * @param card
     *            to be added to the hand
     */
    public void addCard(Card card) {
        cardsInHand.add(card);
    }

    /**
     * Checks if card is in the list then
     * removes it from Hand.
     * 
     * @param card
     *            card to be removed
     * @return Card
     *         if its in the list, returns the card, else
     *         return null if not found
     */
    public Card removeCard(Card card) {
        if (cardsInHand.contains(card)) {
            cardsInHand.remove(card);
            return card;
        }
        LOG.error("Tried to remove card that was not found in hand.");
        return null;

    }

    /**
     * Get method to return an array of a players current cards.
     *
     * @return Card[] array of players current hand
     */
    public Card[] getCardsInHand() {
        Card[] arrayCards = new Card[cardsInHand.size()];
        for (int i = 0; i < cardsInHand.size(); i++) {
            arrayCards[i] = cardsInHand.get(i);
        }
        return arrayCards;
    }

}
