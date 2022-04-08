package edu.skidmore.cs326.spring2022.skribbage.common;

/**
 * Generic Player class.
 * 
 * @author Charlie Davidson
 */

public class Player {
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
     * Constructor method.
     * 
     * @param user
     */
    public Player(User user) {
        this.user = user;
        this.name = null;
        this.username = null;
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
    
}