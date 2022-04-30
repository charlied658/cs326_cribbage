package edu.skidmore.cs326.spring2022.skribbage.common;

import java.util.List;
import java.util.ArrayList;

/**
 * Game contains the state of the game and has getters and setters for the
 * variables. It also has a method to return the index where the Hand of cards
 * played during the pegging phase for a particular player can be found and
 * methods to initialize the list of Hands of pegging cards played during the
 * pegging phase and to initialize the Player list.
 *
 * @author Michael Shriner
 *         Last edited by Charlie Davidson.
 */
public class Game implements GameInterface {

    /** The deck of cards used to play Cribbage. */
    private Deck theDeck;

    /** The list of players who are playing this game of Cribbage. */
    private List<Player> playerList = new ArrayList<Player>();

    /**
     * The total score among the players during the pegging phase of
     * the game (0 <= peggingTotal <= 31).
     */
    private int peggingTotal;

    /** The crib for the game. */
    private Hand cribCards;

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
     * Cards currently in play in center of board.
     */
    private Hand cardsInPlay;

    /**
     * Game constructor.
     *
     * @param numPlayers is the number of players for this game.
     */
    public Game(int numPlayers) {

        cribCards = new Hand();
        peggingTotal = 0;
        state = GameState.START_GAME;
        theDeck = new Deck();
        cardsInPlay = new Hand();
        initPlayers(numPlayers);
        initPeggingCardsPlayed(numPlayers);
    }

    /**
    * Game constructor.
    *
    * @param numPlayers is the number of players for this game.
    * @param aPlayerList is the list of players for this game.
    */
    public Game(int numPlayers, List <Player> aPlayerList) {

        cribCards = new Hand();
        peggingTotal = 0;
        state = GameState.START_GAME;
        theDeck = new Deck();
        cardsInPlay = new Hand();
        setPlayerList(aPlayerList);
        initPeggingCardsPlayed(numPlayers);
    }

    /**
     * Returns the index where the Hand of pegging cards for
     * the parameter player can be found.
     * Only works if Player objects have a user id.
     *
     * @param p is a Player.
     * @return the index where the Hand of pegging cards for
     * the parameter player can be found.
     */
    public int getIdxPlayerPegCards(Player p) {

        int userId = p.getUser().getUserId();

        // find userId in playerList
        for (int i = 0; i < playerList.size(); i++) {
            Player p2 = playerList.get(i);

            if (userId == p2.getUser().getUserId()) {
                return i;
            }
        }

        return -1;
    }


    /**
     * Initialize peggingCardsPlayed.
     *
     * @param numPlayers is the number of players in this game.
     */
    public void initPeggingCardsPlayed(int numPlayers) {
        for (int i = 0; i < numPlayers; i++) {
            peggingCardsPlayed.add(new Hand());
        }
    }


    /**
     * Initializes the ArrayList of Player objects given the
     * number of players for this game. The Player objects added are
     * created using the empty Player constructor.
     *
     * @param numPlayers is the number of players.
     */
    public void initPlayers(int numPlayers) {

        for (int i = 0; i < numPlayers; i++) {
            playerList.add(new Player());
        }
    }

   /**
    * Set the pegging total to the parameter amount of points.
    *
    * @param pts is the points to set the pegging total to.
    */
    public void setPeggingTotal(int pts) {
        peggingTotal = pts;
    }

    /**
     * Get the list of played pegging cards for each Player.
     *
     * @return the list of played pegging cards for each Player.
     */
    public List<Hand> getListOfPeggingCardsPlayed() {
        return peggingCardsPlayed;
    }

    /**
     * Get the cards played during the pegging phase at
     * a particular index.
     *
     * @param index is the index of the Hand to return.
     * @return Hand of cards played during the pegging phase at that index.
     */
    public Hand getPeggingCards(int index) {
        return peggingCardsPlayed.get(index);
    }

    /**
     * Returns the deck for this game.
     *
     * @return the deck.
     */
    public Deck getDeck() {
        return theDeck;
    }

    /**
     * Set the deck.
     *
     * @param deck
     */
    public void setDeck(Deck deck) {
        this.theDeck = deck;
    }

    /**
     * Returns the pegging total for this game.
     *
     * @return the pegging total.
     */
    public int getPeggingTotal() {
        return peggingTotal;
    }

    /**
     * Returns the list of players.
     *
     * @return an ArrayList of players.
     */
    public List<Player> getPlayerList() {
        return playerList;
    }

    /**
     * Sets the list of Players.
     *
     * @param pList is a list of Players.
     */
    public void setPlayerList(List <Player> pList) {
        playerList = pList;
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
     * Set the crib cards.
     *
     * @param cribCards is a Hand of crib cards.
     */
    public void setCribCards(Hand cribCards) {
        this.cribCards = cribCards;
    }

    /**
     * Get the state of the game.
     *
     * @return the state of the game.
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
     * Get the cards currently in play.
     *
     * @return cardsInPlay
     */
    public Hand getCardsInPlay() {
        return this.cardsInPlay;
    }

    /**
     * Set the cards in play.
     * @param cardsInPlay
     */
    public void setCardsInPlay(Hand cardsInPlay) {
        this.cardsInPlay = cardsInPlay;
    }
}
