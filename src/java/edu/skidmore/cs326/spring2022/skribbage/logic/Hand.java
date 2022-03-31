package edu.skidmore.cs326.spring2022.skribbage.logic;

import java.util.ArrayList;

/**
 * Hand Class representing the methods.
 *
 * @author Dorjee
 *         Last Edited: Dorjee
 */
public class Hand {

  /**
   * hand array list.
   */
  private ArrayList<Card> hand = new ArrayList<Card>();

  /**
   * Adding card to hand.
   *
   * @param card
   *          to add
   */
  public void addCardToHand(Card card) {
    hand.add(card);
  }

  /**
   * Removing card from hand.
   *
   * @param card
   *          to remove
   */
  public void removeCardFromHand(Card card) {
    hand.remove(card);
  }

  /**
   * Get method to return an arrayList of cards.
   *
   * @return Hand the players hand
   */
  public ArrayList<Card> getHand() {
    return hand;
  }

}
