package edu.skidmore.cs326.spring2022.skribbage.logic;

import java.util.ArrayList;

/**
 * The current hand for a player.
 *
 * @author Dorjee
 *         Last Edited: Dorjee
 */
public class Hand {

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
   * Get method to return a hand.
   *
   * @return Hand the players hand
   */
  public ArrayList<Card> getHand() {
    return hand;
  }


}
