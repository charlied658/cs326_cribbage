package edu.skidmore.cs326.spring2022.skribbage.logic;
import edu.skidmore.cs326.spring2022.skribbage.common.Hand;

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
     * constructor to initialize player.
     */
    public Player() {
        /**
         * initialize points to 0
         */
        intializePoints();
    }

    /**
     * Get the name of the player.
     * 
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
     * Sets the PlayerHand.
     * 
     * @param playerHand
     *            Player's hand
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
     * initialize points to zero.
     */
    public void intializePoints() {
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
     * Returns true if the player is the dealer.
     * 
     * @return boolean
     */
    public boolean isDealer() {
        return isDealer;
    }

    /**
     * Sets the player to be dealer or not dealer.
     * 
     * @param dealer
     */
    public void setDealer(boolean dealer) {
        isDealer = dealer;
    }

}
