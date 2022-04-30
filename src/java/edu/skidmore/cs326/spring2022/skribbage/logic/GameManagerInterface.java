package edu.skidmore.cs326.spring2022.skribbage.logic;

import java.util.List;
import edu.skidmore.cs326.spring2022.skribbage.common.Game;
import edu.skidmore.cs326.spring2022.skribbage.common.Player;

/**
 * Interface for GameManager.
 *
 * @author Michael Shriner.
 */
interface GameManagerInterface {

    /**
     * Gets the Game object.
     *
     * @return Game.
     */
    Game getGame();

    /**
     * Sets the Game object.
     *
     * @param game is a Game object.
     */
    void setGame(Game game);

    /**
     * Adds a value to the pegging total.
     *
     * @param amountToAdd
     *            is the amount to add to the pegging total.
     * @return true iff the amountToAdd was added successfully.
     */
    boolean addToPeggingTotal(int amountToAdd);


    /** Initializes the pegging total. */
    void initPeggingTotal();

    /**
     * Returns the index in the player list where the dealer is at.
     *
     * @param playerList
     *            is the list of players.
     * @return the index in the player list where the dealer is at.
     */
    int getDealerIdx(List <Player> playerList);

}
