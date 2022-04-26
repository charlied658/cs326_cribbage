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
    private static final int MAXIMUM_LOBBY_SIZE = 3;

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
    private int id;

    /**
     * A host and id are required to create a lobby when keeping
     * track of multiple active lobbies at once.
     * 
     * @param host
     *            The user creating and hosting the lobby.
     * @param id
     *            The id number of the lobby.
     */
    public Lobby(User host, int id) {
        this.host = host;
        users = new User[MAXIMUM_LOBBY_SIZE];
        users[0] = host;
        this.id = id;
    }

    /**
     * Constructor for single active lobby implementation.
     * 
     * @param host
     *            The user creating and hosting the lobby.
     */
    public Lobby(User host) {
        this.host = host;
        users = new User[MAXIMUM_LOBBY_SIZE];
        users[0] = host;
        id = -1;
    }

    /**
     * Allows other classes access to users attribute.
     * 
     * @return users
     */
    public User[] getUsers() {
        return users;
    }

    /**
     * Allows other classes access to host attribute.
     * 
     * @return host
     */
    public User getHost() {
        return host;
    }

    /**
     * Allows other classes access to id attribute.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Add a user to the lobby and update numUsers.
     * 
     * @param user
     */
    public void addUser(User user) {
        if (numUsers < MAXIMUM_LOBBY_SIZE) {
            users[numUsers] = user;
            numUsers += 1;
        }
    }

}
