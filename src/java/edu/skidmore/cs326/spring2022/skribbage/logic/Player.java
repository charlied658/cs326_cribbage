package edu.skidmore.cs326.spring2022.skribbage.logic;

import java.util.ArrayList;

/**
 * @author lappiaha
 */
public class Player {
    /**
     * java doc.
     */
    boolean isDealer = false;

    /**
     * java doc.
     */
    int points = 0;

    /**
     * java doc.
     */
    private ArrayList<Card> cards = new ArrayList<Card>();

    /**
     * java doc.
     */
    private Hand hand = new Hand();

    /**
     * java doc.
     */
    private Deck thedeck = new Deck();

    /**
     * java doc.
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
    public void setName() {

    }

    /**
     * Method sets the PlayerHand.
     */
    public void setHand(Hand playerHand) {

        // thedeck.removeTopCard();
        hand = playerHand;

    }

    /**
     * Get the hand.
     * 
     * @return hand
     */
    public ArrayList<Card> getHand() {
        return hand;
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
