package edu.skidmore.cs326.spring2022.skribbage.common;

/**
 * Methods for creating, destroying, and starting games from lobbies.
 * 
 * @author Declan Morris
 */
public interface LobbyManagement {

    /**
     * Create a new lobby and set host to passed User.
     * 
     * @param host
     * @return Lobby
     */
    Lobby createLobby(User host);

    /**
     * Create a new game object from a lobby and destroy it.
     * 
     * @param lobby
     * @return Game
     */
    Game startGame(Lobby lobby);

    /**
     * Delete a lobby object entirely (to avoid memory leaks).
     * 
     * @param lobby
     */
    void deleteLobby(Lobby lobby);

}
