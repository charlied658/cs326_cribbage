package edu.skidmore.cs326.spring2022.skribbage.common;

import java.util.ArrayList;

/**
 * @author kpolite
 */

public class Deck {
    /**
     * @author kpolite
     *         Attributes:
     *         ArrayList of Cards
     *         Methods:
     *         Constructor
     *         ArrayList<Card> getDeck()
     *         void setDeck()
     */
    private ArrayList<Card> packOfCards;

    /**
     * Array of Suits to use in adding card loop.
     */
    private Suit[] theSuits = Suit.values();

    /**
     * Array of Ranks to use in adding card loop.
     */
    private Rank[] theRanks = Rank.values();

    /**
     * Constructor method.
     */
    public Deck() {
        // Initializes the deck

        // Attributes
        packOfCards = new ArrayList<Card>();

        // Card adding loops
        for (int suit = 0; suit <= 3; suit++) {

            for (int rankIndex = 0; rankIndex <= 12; rankIndex++) { // cards
                                                                    // 2-10
                packOfCards.add(new Card(theRanks[rankIndex], theSuits[suit]));
            } // end numbered card loop

        } // end suit loop

    } // end public Deck

    /**
     * returns a ArrayList<Card> variable, which is the deck.
     * 
     * @return ArrayList<Card>
     */
    public ArrayList<Card> getDeck() {
        return packOfCards;
    } // end getDeck

    /**
     * Sets the deck to a specified ArrayList of cards. 
     * @param deckToSet
     */
    public void setDeck(ArrayList<Card> deckToSet) {
        packOfCards = deckToSet;
    } // end getDeck

} // end Deck Class
