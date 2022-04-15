package edu.skidmore.cs326.spring2022.skribbage.common;

import java.util.ArrayList;

/**
 * Bean class for Hand, that contains a constructor for the Hand, and
 * a set and get method.
 *
 * @author Dorjee
 *         Last Edited: Dorjee
 */
public class Hand {

    /**
     * Creating variable hand to hold a players cards.
     */
    private ArrayList<Card> cardsInHand;

    /**
     * Constructor for Hand that initializes an ArrayList of Cards.
     */
    public Hand() {

        cardsInHand = new ArrayList<Card>();

    }

    /**
     * Takes in a param of cards and sets those to be the hand.
     * 
     * @param cards
     *            cards to be set as the hand.
     */
    public void setCardsInHand(ArrayList<Card> cards) {
        cardsInHand = cards;
    }

    /**
     * Get method to return an arrayList of a players current cards.
     *
     * @return Hand the players current hand
     */
    public ArrayList<Card> getCardsInHand() {
        return cardsInHand;
    }

}
