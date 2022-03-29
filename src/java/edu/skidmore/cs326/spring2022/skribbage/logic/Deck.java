
package edu.skidmore.cs326.spring2022.skribbage.logic;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author INSERT HERE.
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
  ArrayList<Card> theDeck;

  /**
   * theSuits info.
   */
  Suit[] theSuits = Suit.values();
  char[] myChars = { '2', '3', '4', '5', '6', '7', '8', '9', '0' };

  /**
   * insert javadoc.
   */
  public Deck() {
    // Initializes the deck

    // Attributes
    theDeck = new ArrayList<Card>();

    // Card adding loops
    for (int suit = 0; suit <= 3; suit++) {

      theDeck.add(new Card('A', theSuits[suit])); // adds an Ace

      for (int charIndex = 0; charIndex <= 8; charIndex++) {// adds cards 2-10
        theDeck.add(new Card(myChars[charIndex], theSuits[suit]));
      } // end numbered card loop

      theDeck.add(new Card('J', theSuits[suit])); // adds an Jack

      theDeck.add(new Card('Q', theSuits[suit])); // adds an Queen

      theDeck.add(new Card('K', theSuits[suit])); // adds an King

    } // end suit loop

  }// end public Deck

  public void shuffle() {
    ArrayList<Card> tempDeck = new ArrayList<Card>();
    Random randNumGen = new Random();

    for (int i = 0; i <= 52; i++) {
      int randomInt = randNumGen.nextInt(theDeck.size());
      tempDeck.add(theDeck.get(randomInt));
      theDeck.remove(randomInt);
    } // end for loop

    theDeck = tempDeck;

  }// end shuffle

  public Card cut(int whereToCut) {
    return theDeck.get(whereToCut);
  }// end Cut

  public ArrayList<Card> getDeck() {
    return theDeck;
  }// end getDeck

  public Card removeTopCard() {
    Card tempCard = theDeck.get(0);
    theDeck.remove(0);
    return tempCard;
  }// end removeTopCard

  public void moveToTop(int whatCardToMove) {
    Card tempCard = theDeck.get(whatCardToMove + 1);
    theDeck.remove(whatCardToMove);
    theDeck.add(0, tempCard);
  }

}// end Deck Class
