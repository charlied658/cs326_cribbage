package edu.skidmore.cs326.spring2022.skribbage.logic;

import edu.skidmore.cs326.spring2022.skribbage.common.Deck;
import edu.skidmore.cs326.spring2022.skribbage.common.Card;

/**
 * @author kpolite
 */

public interface DeckManipulation {
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
    public void shuffle(Deck deckInstance);

    /**
     * Returns card at indicated index.
     * 
     * @return Card
     * @param whereToCut
     *            index of where you want to cut in the deck
     */
    public Card cut(Deck deckInstance, int whereToCut);

    /**
     * Method removes the top card from the deck and returns it.
     *
     * @return a Card that is removed to the top.
     */
    public Card removeTopCard(Deck deckInstance);

    /**
     * Moves a card to the top.
     *
     * @param whatCardToMove
     *            index of which card to move to the top.
     */
    public void moveToTop(Deck deckInstance, int whatCardToMove);

} // end DeckManipulator
