package edu.skidmore.cs326.spring2022.skribbage.logic;

import org.apache.log4j.Logger;

/**
* @author Declan Morris
* Encompasses all information portrayed by a card
* Card also knows which card type should come after it in a run
*/
public class Card {

  /**
  * The numerical value added to the center sum during play phase
  * (4 of hearts is worth 4, any king is worth 10, etc.)
  */
  private int pointValue;

  /**
  * Getter for pointValue
  */
  public int getPointValue() {
    return pointValue;
  }

  /**
  * The identifying character that would appear on the physical card
  */
  private char identifier;

  public char getIdentifier() {
    return identifier;
  }

  private void setIdentifier(char inIdentifier) {
    switch (inIdentifier) {
      case 'A': pointValue = 1;
                nextIdentifier = '2';
                identifier = inIdentifier;
                break;

      case '2': pointValue = 2;
                nextIdentifier = '3';
                identifier = inIdentifier;
                break;

      case '3': pointValue = 3;
                nextIdentifier = '4';
                identifier = inIdentifier;
                break;

      case '4': pointValue = 4;
                nextIdentifier = '5';
                identifier = inIdentifier;
                break;

      case '5': pointValue = 5;
                nextIdentifier = '6';
                identifier = inIdentifier;
                break;

      case '6': pointValue = 6;
                nextIdentifier = '7';
                identifier = inIdentifier;
                break;

      case '7': pointValue = 7;
                nextIdentifier = '8';
                identifier = inIdentifier;
                break;

      case '8': pointValue = 8;
                nextIdentifier = '9';
                identifier = inIdentifier;
                break;

      case '9': pointValue = 9;
                nextIdentifier = '0';
                identifier = inIdentifier;
                break;

      case '0': pointValue = 10;
                nextIdentifier = 'J';
                identifier = inIdentifier;
                break;

      case 'J': pointValue = 10;
                nextIdentifier = 'Q';
                identifier = inIdentifier;
                break;

      case 'Q': pointValue = 10;
                nextIdentifier = 'K';
                identifier = inIdentifier;
                break;

      case 'K': pointValue = 10;
                nextIdentifier = 'N';
                identifier = inIdentifier;
                break;

      default:  System.out.println("ERROR: invalid identifier passed to constructor");
                break;
    }
  }

  /**
  * The identifier of the next valid card in a run
  */
  private char nextIdentifier;

  /**
  * Getter for nextIdentifier (automatically set when identifier is set)
  */
  public char getNextIdentifier() {
    return nextIdentifier;
  }

  /**
  * The card's suite (must be one of HEARTS, CLUBS, DIAMONDS, SPADES)
  */
  private Suit suit;

  /**
  * Getter for suit
  */
  public Suit getSuit() {
    return suit;
  }

  /**
  * Setter for suit
  * @param inSuit input suit
  */
  private void setSuit(Suit inSuit) {
    suit = inSuit;
  }

  /**
  * Constructor that assigns parameterized values to all attributes
  * @param inSuit inputted suit
  * @param inIdentifier inputted identifier
  */
  public Card(char inIdentifier, Suit inSuit) {
    setSuit(inSuit);
    setIdentifier(inIdentifier);
  }
}
