package edu.skidmore.cs326.spring2022.skribbage.logic;

import edu.skidmore.cs326.spring2022.skribbage.common.Deck;
import edu.skidmore.cs326.spring2022.skribbage.common.Card;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author kpolite
 */

public class DeckManipulator implements DeckManipulation {
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

    /**
     * Method to shuffle the deck.
     */
    public void shuffle(Deck deckInstance) {
        ArrayList<Card> tempDeck = new ArrayList<Card>();
        Random randNumGen = new Random();

        for (int i = 0; i < 52; i++) {
            int randomInt = randNumGen.nextInt(deckInstance.getDeck().size());
            tempDeck.add(deckInstance.getDeck().get(randomInt));
            deckInstance.getDeck().remove(randomInt);
        } // end for loop

        deckInstance.setDeck(tempDeck);

    } // end shuffle

    /**
     * Returns card at indicated index.
     * 
     * @return Card
     * @param whereToCut
     *            index of where you want to cut in the deck
     */
    public Card cut(Deck deckInstance, int whereToCut) {
        return deckInstance.getDeck().get(whereToCut);
    } // end Cut

    /**
     * Method removes the top card from the deck and returns it.
     *
     * @return a Card that is removed to the top.
     */
    public Card removeTopCard(Deck deckInstance) {
        Card tempCard = deckInstance.getDeck().get(0);
        deckInstance.getDeck().remove(0);
        return tempCard;
    } // end removeTopCard

    /**
     * Moves a card to the top.
     *
     * @param whatCardToMove
     *            index of which card to move to the top.
     */
    public void moveToTop(Deck deckInstance, int whatCardToMove) {
        Card tempCard = deckInstance.getDeck().get(whatCardToMove + 1);
        deckInstance.getDeck().remove(whatCardToMove);
        deckInstance.getDeck().add(0, tempCard);
    }

} // end DeckManipulator
