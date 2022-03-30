package edu.skidmore.cs326.spring2022.skribbage.logic;

import java.util.ArrayList;

/**
 * @author lappiaha
 */
public class Player {
  /**
   * initializes the player's points
   */
  int points;
  /**
   * Creates hand object
   */
  private Hand hand = new Hand();
  /**
   * string to keep the player name
   */
  private String playername;
  /**
   * 
   */
  public boolean isDealer;

  /**
   * boolean to help determine the dealer of the game
   */
  public Player() {
    // initializes the player

    // initializes the deck
    // this.thedeck = new Deck();

  }

  /**
   * Get the name of the player.
   */
  public void getName() {
    // need info from frontEnd
    // player1 = name1.getName();
    // player2 = name2.getName();
    // claims the player name
  }

  /**
   * Set the name of the player.
   */
  public String setName() {
    return playername;
  }

  /**
   * Method sets the PlayerHand.
   */
  public void setHand(Hand playerHand) {

    hand = playerHand;
  }

  /**
   * Get the hand.
   * 
   * @return hand
   */
  public Hand getHand() {
    return hand;
  }

  /**
   * initializes points to 0
   * 
   * @return
   */
  public int setPoints() {
    points = 0;
  }

  /**
   * Get the player points.
   * 
   * @return points
   */
  public int getPoints() {
    return points;
  }

  /**
   * Add the player points.
   * 
   * @param pointsToAdd
   */
  public void addPoints(int pointsToAdd) {
    points += pointsToAdd;

  }

}
