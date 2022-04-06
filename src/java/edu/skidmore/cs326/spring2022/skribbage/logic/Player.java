package edu.skidmore.cs326.spring2022.skribbage.logic;

/**
 * @author lappiaha
 */
public class Player {
    /**
     * initializes the player's points.
     */
    private int points;

    /**
     * Creates hand object.
     */
    private Hand hand = new Hand();

    /**
     * String to keep the player name.
     */
    private String playername;
    
    /**
     * boolean to help determine the dealer of the game.
     */
    private boolean isDealer;

    /**
     * Player constructor.
     */
    public Player() {
        /**
         * initialize points to 0
         */
        intializePoints();
    }

    /**
     * Get the name of the player.
     * @return Player's name
     */
    public String getName() {
        // need info from frontEnd
        // player1 = name1.getName();
        // player2 = name2.getName();
        // claims the player name
        return playername;
    }

    /**
     * Set the name of the player.
     * @param name
     */
    public void setName(String name) {
        playername = name;
    }

    /**
     * Sets the PlayerHand.
     * @param playerHand Player's hand
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
     * Initialize points to 0.
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
     * Add the player points.
     * 
     * @param pointsToAdd
     */
    public void addPoints(int pointsToAdd) {
        points += pointsToAdd;

    }
    
    /**
     * Returns true if the player is the dealer.
     * @return boolean
     */
    public boolean isDealer() {
        return isDealer;
    }
    
    /**
     * Sets the player to be dealer or not dealer.
     * @param dealer
     */
    public void setDealer(boolean dealer) {
        isDealer = dealer;
    }
    
}