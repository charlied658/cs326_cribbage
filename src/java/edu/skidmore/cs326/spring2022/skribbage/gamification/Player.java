package edu.skidmore.cs326.spring2022.skribbage.gamification;

/**
 * Generic Player class.
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
     * Avatar of player.
     */
    private Avatar avatar;

    /**
     * Generic Player object.
     * @param username  Name of player
     */
    public Player(String username) {
        this.username = username;
        this.name = null;
        this.avatar = null;
    }

    /**
     * Get player username.
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Get player name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Get player avatar.
     * @return avatar
     */
    public Avatar getAvatar() {
        return avatar;
    }

    /**
     * Set player name.
     * @param name Player name
     */
    public void setString(String name) {
        this.name = name;
    }

    /**
     * Set player avatar.
     * @param avatar Player name
     */
    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

}
