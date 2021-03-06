package edu.skidmore.cs326.spring2022.skribbage.common;

import java.util.List;
import java.util.ArrayList;

/**
 * Interface for Game.
 *
 * @author Michael Shriner.
 */
interface GameInterface {

    /**
     * The Deck for the Game.
     */
    Deck THE_DECK = new Deck();

    /** The list of players who are playing this game of Cribbage. */
    List<Player> PLAYER_LIST = new ArrayList<Player>();

    /**
     * The total score among the players during the pegging phase of
     * the game (0 <= peggingTotal <= 31).
     */
    int PEGGING_TOTAL = 0;

    /** The crib for the game. */
    Hand CRIB_CARDS = new Hand();

    /**
     * Initializes the players for this Game. Creates Player objects
     * using the empty Player constructor.
     *
     * @param numPlayers is the number of players for this Game.
     */
    void initPlayers(int numPlayers);

    /**
     * Initializes the list of Hand objects where each Hand is a
     * list of cards played during the pegging play phase.
     *
     * @param numPlayers is the number of players for this Game.
     */
    void initPeggingCardsPlayed(int numPlayers);

    /**
     * Sets the pegging total to the parameter points.
     *
     * @param pts is the points to assign to the pegging total.
     */
    void setPeggingTotal(int pts);

    /**
     * Returns the Game's Deck.
     *
     * @return the Game's Deck.
     */
    Deck getDeck();

    /**
     * Returns the current pegging total of this Game.
     *
     * @return the current pegging total of this Game.
     */
    int getPeggingTotal();

    /**
     * Returns the list of Player objects for this Game.
     *
     * @return the list of Player objects for this Game.
     */
    List<Player> getPlayerList();

    /**
     * Returns the crib for this Game.
     *
     * @return this Game's crib.
     */
    Hand getCribCards();

}
