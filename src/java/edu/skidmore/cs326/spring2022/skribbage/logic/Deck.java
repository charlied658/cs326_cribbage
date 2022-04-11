
package edu.skidmore.cs326.spring2022.skribbage.logic;

import java.util.ArrayList;
import java.util.Random;

import edu.skidmore.cs326.spring2022.skribbage.common.Suit;

/**
 *
 * TODO (DSR): Deck functionality needs to move to the common package
 * TODO (DSR): Lets talk through the design of Card, Hand, Deck...

 * @author kpolite
 *
 */

public class Deck {
    /**
     * @author kpolite
     *         Attributes:
     *         Card Object
     *         ArrayList of Cards
     *         Methods:
     *         constructor
     *         Void Shuffle()
     *         Card Cut()
     *         Deck getDeck()
     *         Card RemoveTopCard()
     */
    private ArrayList<Card> theDeck;

    /**
     * Array of Suits to use in adding card loop.
     */
    private Suit[] theSuits = Suit.values();

    /**
     * Array of Chars to use in adding card loop.
     */
    private char[] myChars = { '2', '3', '4', '5', '6', '7', '8', '9', '0' };

    /**
     * Constructor method.
     */
    public Deck() {
        // Initializes the deck

        // Attributes
        theDeck = new ArrayList<Card>();

        // Card adding loops
        for (int suit = 0; suit <= 3; suit++) {

            theDeck.add(new Card('A', theSuits[suit])); // adds an Ace

            for (int charIndex = 0; charIndex <= 8; charIndex++) { //cards 2-10
                theDeck.add(new Card(myChars[charIndex], theSuits[suit]));
            } // end numbered card loop

            theDeck.add(new Card('J', theSuits[suit])); // adds an Jack

            theDeck.add(new Card('Q', theSuits[suit])); // adds an Queen

            theDeck.add(new Card('K', theSuits[suit])); // adds an King

        } // end suit loop

    } // end public Deck

    /**
     * Method to shuffle the deck.
     */
    public void shuffle() {
        ArrayList<Card> tempDeck = new ArrayList<Card>();
        Random randNumGen = new Random();

        for (int i = 0; i < 52; i++) {
            int randomInt = randNumGen.nextInt(theDeck.size());
            tempDeck.add(theDeck.get(randomInt));
            theDeck.remove(randomInt);
        } // end for loop

        theDeck = tempDeck;

    } // end shuffle

    /**
     * Returns card at indicated index.
     *@return Card
     *@param  whereToCut index of where you want to cut in the deck
     */
    public Card cut(int whereToCut) {
        return theDeck.get(whereToCut);
    } // end Cut

    /**
     * returns a ArrayList<Card> variable, which is the deck.
     *@return ArrayList<Card>
     */
    public ArrayList<Card> getDeck() {
        return theDeck;
    } // end getDeck

    /**
     * Method removes the top card from the deck and returns it.
     *
     * @return a Card that is removed to the top.
     */
    public Card removeTopCard() {
        Card tempCard = theDeck.get(0);
        theDeck.remove(0);
        return tempCard;
    } // end removeTopCard

    /**
     * Moves a card to the top.
     *
     * @param whatCardToMove
     *          index of which card to move to the top.
     */
    public void moveToTop(int whatCardToMove) {
        Card tempCard = theDeck.get(whatCardToMove + 1);
        theDeck.remove(whatCardToMove);
        theDeck.add(0, tempCard);
    }

} // end Deck Class
