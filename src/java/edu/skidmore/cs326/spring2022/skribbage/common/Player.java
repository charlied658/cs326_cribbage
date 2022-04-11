package edu.skidmore.cs326.spring2022.skribbage.common;

import java.util.HashMap;

import edu.skidmore.cs326.spring2022.skribbage.gamification.Avatar;
import edu.skidmore.cs326.spring2022.skribbage.logic.Hand;

/**
 * Generic Player class used by logic and gamification.
 * @author Charlie Davidson
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
     * Username of player.
     */
    private String username;

    /**
     * Name of player.
     */
    private String name;

    /**
     * User associated with player.
     */
    private User user;
    
    /**
     * Inventory of the player.
     */
    private HashMap<String, Integer> inventory;
    
    /**
    * Avatar of player.
    */
    private Avatar avatar;
    
    /**
     * boolean to help determine the dealer of the game.
     */
    private boolean isDealer;
    
    /**
     * Constructor method.
     * 
     * @param user
     */
    public Player(User user) {
        this.user = user;
        this.name = null;
        this.username = null;
        this.inventory = new HashMap<String, Integer>();
        this.avatar = null;
        intializePoints();
    }

    /**
     * Get player username.
     * 
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Get player name.
     * 
     * @return name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Get user associated with player.
     * 
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * Set player name.
     * 
     * @param name
     *            Player name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Set player username.
     * 
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * Set player user.
     * 
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }
    
    /**
     * Get player inventory.
     * @return inventory
     */
    public HashMap<String, Integer> getInventory() {
        return inventory;
    }
    
    /**
     * Set player inventory.
     * @param inventory
     */
    public void setInventory(HashMap<String, Integer> inventory) {
        this.inventory = inventory;
    }
    
    /**
     * Get player avatar.
     * 
     * @return avatar
     */
    public Avatar getAvatar() {
        return avatar;
    }
    
    /**
     * Set player avatar.
     * 
     * @param avatar
     */
    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
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
     * Get the player points.
     * 
     * @return points
     */
    public int getPoints() {
        return points;
    }
    
    /**
     * Initialize points to 0.
     */
    public void intializePoints() {
        points = 0;
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