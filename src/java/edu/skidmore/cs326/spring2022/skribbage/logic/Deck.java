package edu.skidmore.cs326.spring2022.skribbage.logic;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author kpolite
 */

public class Deck {
    /**
     * @author kpolite
     *         Attributes:
     *         ArrayList of Cards
     *         Methods:
     *         shuffle()
     *         cut(int whereToCut)
     *         removeTopCard()
     *         moveToTop(int whatCardToMove)
     */

    private ArrayList<Card> packOfCards;
    
    /**
     * Method to shuffle the deck.
     */
    public void shuffle() {
        ArrayList<Card> tempDeck = new ArrayList<Card>();
        Random randNumGen = new Random();

        for (int i = 0; i < 52; i++) {
            int randomInt = randNumGen.nextInt(packOfCards.size());
            tempDeck.add(packOfCards.get(randomInt));
            packOfCards.remove(randomInt);
        } // end for loop

        packOfCards = tempDeck;

    } // end shuffle

    /**
     * Returns card at indicated index.
     * 
     * @return Card
     * @param whereToCut
     *            index of where you want to cut in the deck
     */
    public Card cut(int whereToCut) {
        return packOfCards.get(whereToCut);
    } // end Cut

    /**
     * Method removes the top card from the deck and returns it.
     *
     * @return a Card that is removed to the top.
     */
    public Card removeTopCard() {
        Card tempCard = packOfCards.get(0);
        packOfCards.remove(0);
        return tempCard;
    } // end removeTopCard

    /**
     * Moves a card to the top.
     *
     * @param whatCardToMove
     *            index of which card to move to the top.
     */
    public void moveToTop(int whatCardToMove) {
        Card tempCard = packOfCards.get(whatCardToMove + 1);
        packOfCards.remove(whatCardToMove);
        packOfCards.add(0, tempCard);
    }

} // end Deck Class
