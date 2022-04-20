package edu.skidmore.cs326.spring2022.skribbage.common;

/**
 * Holds data representing users waiting for their game to start.
 * 
 * @author Declan Morris
 */
public class Lobby {
    
    /**
     * The maximum number of users that can be in one lobby.
     */
    private static final int MAXIMUM_LOBBY_SIZE = 4;
    
    /**
     * The number of users currently in the lobby.
     */
    private int numUsers;
    
    /**
     * All the users waiting in the lobby.
     */
    private User[] users;
    
    /**
     * The user who has authority to start the game.
     */
    private User host;
    
    /**
     * The id associated with the lobby for data-tracking purposes.
     */
    private Integer id;
    
    /**
     * A host is required to start a lobby.
     * @param host
     */
    public Lobby(User host) {
        this.host = host;
        users = new User[MAXIMUM_LOBBY_SIZE];
        users[0] = host;
    }
    
    /**
     * Allows other classes access to users attribute.
     * @return users
     */
    public User[] getUsers() {
        return users;
    }
    
    /**
     * Allows other classes access to host attribute.
     * @return host
     */
    public User getHost() {
        return host;
    }
    
    /**
     * Allows other classes access to id attribute.
     * @return id
     */
    public Integer getId() {
        return id;
    }
    
    /**
     * Add a user to the lobby and update numUsers.
     * @param user
     */
    public void addUser(User user) {
        if (numUsers < MAXIMUM_LOBBY_SIZE) {
            
        }
    }

}
