package edu.skidmore.cs326.spring2022.skribbage.common;

import edu.skidmore.cs326.spring2022.skribbage.frontend.PageManager;
import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * Singleton class for creating, destroying, and creating Games from lobbies.
 * Keeps track of existing lobbies in Lobby[] attribute.
 * 
 * @author Declan Morris
 */
public class LobbyManager implements LobbyManagement {

    /**
     * The only instance of LobbyManager that should exist.
     */
    private static LobbyManager instance;

    /**
     * Finds the first empty element in the array of lobbies.
     * 
     * @return index
     */
    private int nextEmptyIndex() {
        for (int i = 0; i < lobbies.length; i++) {
            if (lobbies[i] == null) {
                return i;
            }
        }
        return 0;

    }

    /**
     * Empty private constructor to allow for singleton functionality.
     */
    private LobbyManager() {

    }

    /**
     * The lobbies tracked by LobbyManager.
     */
    private static Lobby[] lobbies = new Lobby[100];

    /**
     * The one activeLobby used until multi-game/multi-lobby implementation is
     * added.
     */
    private Lobby activeLobby;

    /**
     * logger.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(PageManager.class);
    }

    /**
     * Lazy initialization of instance in getter method for instance that
     * allows other classes to access.
     * 
     * @return instance
     */
    public static LobbyManager getInstance() {
        if (instance == null) {
            instance = new LobbyManager();
            Arrays.fill(lobbies, null);
        }
        return instance;
    }

    @Override
    public Lobby createLobby(User host) {

        int newIndex = nextEmptyIndex();
        Lobby lobbyToCreate = new Lobby(host, newIndex);
        lobbies[newIndex] = lobbyToCreate;
        this.activeLobby = lobbyToCreate;
        LOG.trace(this.getActiveLobby().toString());

        return lobbies[newIndex];

    }

    @Override
    public Game startGame(Lobby lobby) {
        deleteLobby(lobby);
        return null;
    }

    @Override
    public void deleteLobby(Lobby lobby) {

        lobbies[lobby.getId()] = null;
        this.activeLobby = null;

    }

    @Override
    public void addUser(User user, Lobby lobby) {
        lobby.addUser(user);
    }

    /**
     * Allows other classes to modify activeLobby.
     * 
     * @param lobby
     */
    public void setActiveLobby(Lobby lobby) {
        activeLobby = lobby;
    }

    /**
     * Allows other classes access to reference activeLobby attribute.
     * 
     * @return activeLobby
     */
    public Lobby getActiveLobby() {
        return activeLobby;
    }

}
