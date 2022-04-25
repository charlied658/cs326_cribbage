package edu.skidmore.cs326.spring2022.skribbage.common;

/**
 * Singleton class for creating, destroying, and creating Games from lobbies.
 * Keeps track of existing lobbies in Lobby[] attribute.
 * @author Declan Morris
 *
 */
public class LobbyManager implements LobbyManagement {
    
    /**
     * The only instance of LobbyManager that should exist.
     */
    private static LobbyManager instance;
    
    /**
     * Finds the first empty element in the array of lobbies.
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
    private Lobby[] lobbies = new Lobby[100];
    
    /**
     * Lazy initialization of instance in getter method for instance that
     * allows other classes to access.
     * @return instance
     */
    public LobbyManager getInstance() {
        if (instance == null) {
            instance = new LobbyManager();
            for (int i = 0; i < lobbies.length; i++) {
                lobbies[i] = null;
            }
        }
        return instance;
    }

    @Override
    public void createLobby(User host) {
        int newIndex = nextEmptyIndex();
        lobbies[nextEmptyIndex()] = new Lobby(host);
    }

    @Override
    public Game startGame(Lobby lobby) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteLobby(Lobby lobby) {
        // TODO Auto-generated method stub
        
    }

}
