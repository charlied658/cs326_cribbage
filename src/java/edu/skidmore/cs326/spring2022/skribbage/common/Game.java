package edu.skidmore.cs326.spring2022.skribbage.common;

import java.util.List;
import java.util.ArrayList;

//import org.apache.log4j.Logger;

/**
 * Game contains the state of the game. It has a deck, a list of players, a
 * pegging total, a list of cards in the crib, and lists of cards played during
 * pegging play by the pone and dealer. It contains getter and setter methods.
 * Currently, a key assumption for this class is that there are only two
 * players.
 *
 * @author Michael Shriner
 *         Last edited by Charlie Davidson
 */
public class Game implements GameInterface {

    /** The deck of cards used to play Cribbage. */
    private Deck theDeck = new Deck();

    /** The list of players who are playing this game of Cribbage. */
    private List<Player> playerList = new ArrayList<Player>();

    /**
     * The total score among the players during the pegging phase of
     * the game (0 <= peggingTotal <= 31).
     */
    private int peggingTotal;

    /** The crib for the game. */
    private Hand cribCards;

    /** The set of cards played by the pone during the pegging phase. */
    // private List <Card> ponePeggingCards;
    // private Hand ponePeggingCards;

    /** The set of cards played by the dealer during the pegging phase. */
    // private Hand dealerPeggingCards;

    /**
     * A list of Hand objects where each Hand is a list of cards played during
     * the pegging play phase. The Hand at index i in peggingCardsPlayed
     * belongs to the Player at index i in playerList.
     */
    private List<Hand> peggingCardsPlayed = new ArrayList<Hand>();

    /**
     * State of the game.
     */
    private GameState state;

    /**
     * Copy of the standard sorted deck. Should never be modified.
     */
    private Deck standardDeck;

    /**
     * Cards currently in the deck.
     */
    private Deck cardsInDeck;

    /**
     * Cards currently in play in center of board.
     */
    private Hand cardsInPlay;

    /**
     * Cards currently in the player's hand.
     */
    private Hand cardsInHand;

    /**
     * Cards currently in the opponent's hand.
     */
    private Hand cardsInOpponentHand;

    /**
     * Game constructor. It initializes the list of players,
     * the pegging total the ArrayList of the pone's pegging cards,
     * the ArrayList of the dealer's pegging cards, and the crib.
     * It assumes that there are two players.
     *
     * @param numPlayers
     *            is the number of players for this
     *            game.
     */
    public Game(int numPlayers) {

        // ponePeggingCards = new ArrayList<Card>();
        // ponePeggingCards = new Hand();
        // dealerPeggingCards = new Hand();
        cribCards = new Hand();
        peggingTotal = 0;
        state = GameState.START_GAME;
        standardDeck = new Deck();
        cardsInDeck = new Deck();
        cardsInPlay = new Hand();
        cardsInHand = new Hand();
        cardsInOpponentHand = new Hand();
        initPlayers(numPlayers);
        initPeggingCardsPlayed(numPlayers);
    }

    /**
     * Initialize pegging cards.
     * @param numPlayers
     */
    public void initPeggingCardsPlayed(int numPlayers) {
        for (int i = 0; i < numPlayers; i++) {
            peggingCardsPlayed.add(new Hand());
        }
    }

    /**
     * Initializes the ArrayList of Player objects given the
     * number of players for this game. However, there is
     * the assumption, for now, that the number of players
     * is 2.
     *
     * @param numPlayers
     *            is the number of players.
     */
    public void initPlayers(int numPlayers) {

        for (int i = 0; i < numPlayers; i++) {
            playerList.add(new Player());
        }
    }

    /**
     * Set the pegging total to the parameter amount of points.
     *
     * @param pts
     *            is the points to set the pegging total to.
     */
    public void setPeggingTotal(int pts) {
        peggingTotal = pts;
    }

    /**
     * Get list of played pegging cards.
     * @return peggingCardsPlayed
     */
    public List<Hand> getListOfPeggingCardsPlayed() {
        return peggingCardsPlayed;
    }

    /**
     * Get pegging cards.
     * @param index
     * @return pegging card at that index
     */
    public Hand getPeggingCards(int index) {
        return peggingCardsPlayed.get(index);
    }

    // /**
    // * Sets the pone's pegging cards to the parameter.
    // *
    // * @param ponePegCards
    // * is an ArrayList of Card objects.
    // */
    // public void setPonePeggingCards(Hand ponePegCards) {
    // ponePeggingCards = ponePegCards;
    // }

    // /**
    // * Sets the dealer's pegging cards to the parameter.
    // *
    // * @param dealerPegCards
    // * is an ArrayList of Card objects.
    // */
    // public void setDealerPeggingCards(Hand dealerPegCards) {
    // dealerPeggingCards = dealerPegCards;
    // }

    /**
     * Returns the deck for this game.
     *
     * @return the deck.
     */
    public Deck getDeck() {
        return theDeck;
    }

    /**
     * Returns the pegging total for this game.
     *
     * @return the pegging total.
     */
    public int getPeggingTotal() {
        return peggingTotal;
    }

    // /**
    // * Returns the pone's pegging cards as an ArrayList of Card objects.
    // *
    // * @return the pone's pegging cards.
    // */
    // public Hand getPonePeggingCards() {
    // return ponePeggingCards;
    // }

    // /**
    // * Returns the dealers's pegging cards as an ArrayList of Card objects.
    // *
    // * @return the dealer's pegging cards.
    // */
    // public Hand getDealerPeggingCards() {
    // return dealerPeggingCards;
    // }

    /**
     * Returns the list of players.
     *
     * @return an ArrayList of players.
     */
    public List<Player> getPlayerList() {
        return playerList;
    }

    /**
     * Returns the crib.
     *
     * @return the crib as an ArrayList of Card objects.
     */
    public Hand getCribCards() {
        return cribCards;
    }

    /**
     * Get the state of the game.
     *
     * @return state
     */
    public GameState getState() {
        return this.state;
    }

    /**
     * Set the state of the game.
     *
     * @param state
     */
    public void setState(GameState state) {
        this.state = state;
    }

    /**
     * Get the standard deck.
     *
     * @return standardDeck
     */
    public Deck getStandardDeck() {
        return this.standardDeck;
    }

    /**
     * Get the cards in the deck.
     *
     * @return cardsInDeck
     */
    public Deck getCardsInDeck() {
        return this.cardsInDeck;
    }

    /**
     * Get the cards currently in play.
     *
     * @return cardsInPlay
     */
    public Hand getCardsInPlay() {
        return this.cardsInPlay;
    }

    /**
     * Get the cards in the player's hand.
     *
     * @return cardsInHand
     */
    public Hand getCardsInHand() {
        return this.cardsInHand;
    }

    /**
     * Get the cards in the crib.
     *
     * @return cardsInCrib
     */
    public Hand getCardsInCrib() {
        return this.cribCards;
    }

    /**
     * Get the cards in the opponent's hand.
     *
     * @return cardsInOpponentHand
     */
    public Hand getCardsInOpponentHand() {
        return this.cardsInOpponentHand;
    }

}
