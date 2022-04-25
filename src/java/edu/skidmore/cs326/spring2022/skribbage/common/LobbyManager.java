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
     * Empty private constructor to allow for singleton functionality.
     */
    private LobbyManager() {
        
    }
    
    /**
     * Lazy initialization of instance in getter method for instance that
     * allows other classes to access.
     * @return
     */
    public LobbyManager getInstance() {
        if (instance == null) {
            instance = new LobbyManager();
        }
        return instance;
    }

    @Override
    public void createLobby(User host) {
        // TODO Auto-generated method stub
        
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
