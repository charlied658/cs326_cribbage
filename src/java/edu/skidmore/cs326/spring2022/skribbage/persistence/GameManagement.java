package edu.skidmore.cs326.spring2022.skribbage.persistence;

import edu.skidmore.cs326.spring2022.skribbage.common.Game;
import edu.skidmore.cs326.spring2022.skribbage.common.User;

/**
 * game management class.
 * 
 * @author Ricardo Rosario
 */
public interface GameManagement {

    /**
     * retrieve game method.
     * 
     * @param userName
     * @param whichGame
     * @return the game.
     */
    Game retrieveGame(User userName, Game whichGame);

    /**
     * save game method.
     * @param currentGame
     * @return the game.
     */
    boolean saveGame(Game currentGame);

}
