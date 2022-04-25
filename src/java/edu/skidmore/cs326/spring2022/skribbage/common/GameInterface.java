package edu.skidmore.cs326.spring2022.skribbage.common;

import java.util.*;

/**
 * Interface for Game.
 *
 * @author Michael Shriner
 */
interface GameInterface {

    /**
     * theDeck.
     */
    Deck theDeck = new Deck();

    /** The list of players who are playing this game of Cribbage. */
    List<Player> playerList = new ArrayList<Player>();

    /**
     * The total score among the players during the pegging phase of
     * the game (0 <= peggingTotal <= 31).
     */
    int peggingTotal = 0;

    /** The crib for the game. */
    Hand cribCards = new Hand();

    /** The set of cards played by the pone during the pegging phase. */
    Hand ponePeggingCards = new Hand();

    /** The set of cards played by the dealer during the pegging phase. */
    Hand dealerPeggingCards = new Hand();

    /**
     * initPlayers method.
     *
     * @param numPlayers
     */
    void initPlayers(int numPlayers);

    /**
     * Sets the pegging total to the parameter points.
     *
     * @param pts
     *            is the points to assign to the pegging total.
     */
    void setPeggingTotal(int pts);

    /**
     * Sets the pone's pegging cards.
     *
     * @param ponePegCards
     *            is a list of Cards to assign to the pone's pegging
     *            cards.
     */
    void setPonePeggingCards(Hand ponePegCards);

    /**
     * Sets the dealer's pegging cards.
     *
     * @param dealerPegCards
     *            is a list of Cards to assign to the dealer's
     *            pegging cards.
     */
    void setDealerPeggingCards(Hand dealerPegCards);

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
     * Returns the pone's pegging cards for this Game.
     *
     * @return this Game's pone's pegging cards.
     */
    Hand getPonePeggingCards();

    /**
     * Returns the dealer's pegging cards for this Game.
     *
     * @return this Game's dealer's pegging cards.
     */
    Hand getDealerPeggingCards();

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
