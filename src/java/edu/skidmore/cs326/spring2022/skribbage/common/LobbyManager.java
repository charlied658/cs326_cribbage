package edu.skidmore.cs326.spring2022.skribbage.common;

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
        lobbies[newIndex] = new Lobby(host, newIndex);
        return lobbies[newIndex];
        
    }

    @Override
    public Game startGame(Lobby lobby) {
        return null;
    }

    @Override
    public void deleteLobby(Lobby lobby) {

        lobbies[lobby.getId()] = null;

    }

}
