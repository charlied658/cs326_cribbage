package edu.skidmore.cs326.spring2022.skribbage.logic;

import java.util.ArrayList;
import edu.skidmore.cs326.spring2022.skribbage.common.Game;
import edu.skidmore.cs326.spring2022.skribbage.common.Card;
import edu.skidmore.cs326.spring2022.skribbage.common.Player;

/**
 * Interface for GameManager.
 *
 * @author Michael Shriner
 */
interface GameManagerInterface {

    /**
     * getGame.
     * 
     * @return game
     */
    Game getGame();

    /**
     * setGame.
     * 
     * @param game
     */
    void setGame(Game game);

    /**
     * Initializes the list of players.
     *
     * @param numPlayers
     *            is the number of players.
     * @param playerList
     *            is the list of players.
     */
    // void initPlayers(int numPlayers, ArrayList<Player> playerList);

    /**
     * Adds a player to the list of players.
     *
     * @param p
     *            is the player to add to the list of players.
     * @param playerList
     *            is the list of players.
     */
    // void addPlayer(Player p, ArrayList<Player> playerList);

    /**
     * Adds a value to the pegging total.
     *
     * @param amountToAdd
     *            is the amount to add to the pegging total.
     * @return true iff the amountToAdd was added successfully.
     */
    boolean addToPeggingTotal(int amountToAdd);

    /**
     * Adds a card to the list of the pone's pegging cards.
     *
     * @param c
     *            is the card to add to the pone's list of pegging cards.
     */
    void addPonePeggingCard(Card c);

    /**
     * Adds a card to the list of the dealer's pegging cards.
     *
     * @param c
     *            is the card to add to the dealer's list of pegging cards.
     */
    void addDealerPeggingCard(Card c);

    /** Initializes the pegging total. */
    void initPeggingTotal();

    /**
     * Returns the index in the player list where the dealer is at.
     *
     * @param playerList
     *            is the list of players.
     * @return the index in the player list where the dealer is at.
     */
    int getDealerIdx(ArrayList<Player> playerList);

}
