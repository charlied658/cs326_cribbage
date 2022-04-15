
package edu.skidmore.cs326.spring2022.skribbage.logic;


/**
 * @author lappiaha
 */
public class Player {
    /**
     * boolean that will determine which player is the dealer.
     */
    private boolean isDealer = false;
    /**
     * int to for the player's game points.
     */
    private int points;
    /**
     * object to utilize hand class for player.
     */
    private Hand hand = new Hand();
    /**
     * String to hold the player name.
     */
 
    private String playerName;
    /**
     * contructor to initialize player. 
     */
    public Player() {
        // initializes the player
    }

    /**
     * Get the name of the player.
     * @return playerName
     */
    public String getName() {
        return playerName;
    }

    /**
     * Set the name of the player.
     */
    public void setName() {
        // claims the player name
    }
    /**
     * set the hand to the player's hand.
     * @param playerHand
     */
    public void setHand(Hand playerHand) {
        hand = playerHand;

    }

    /**
     * Method to get the hand.
     * 
     * @return hand
     */
    public Hand getHand() {
        return hand;
    }

    /**
     * Initializes points to 0.
     */
    public void setPoints() {
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

}
