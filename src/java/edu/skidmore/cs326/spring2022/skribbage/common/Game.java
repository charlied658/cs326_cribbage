package edu.skidmore.cs326.spring2022.skribbage.common;

import edu.skidmore.cs326.spring2022.skribbage.logic.Deck;
import java.util.ArrayList;
import edu.skidmore.cs326.spring2022.skribbage.logic.GameManager;
//import org.apache.log4j.Logger;

/**
 * Game contains the state of the game. It has a deck, a list of players, a
 * pegging total, a list of cards in the crib, and lists of cards played during
 * pegging play by the pone and dealer. It contains getter and setter methods.
 * Currently, a key assumption for this class is that there are only two
 * players.
 *
 * @author Michael Shriner
 */
public class Game {

    /** The deck of cards used to play Cribbage. */
    private Deck theDeck = new Deck();

    /** The list of players who are playing this game of Cribbage. */
    private ArrayList<Player> playerList = new ArrayList<Player>();

    /**
     * The total score among the players during the pegging phase of
     * the game (0 <= peggingTotal <= 31).
     */
    private int peggingTotal;

    /** The crib for the game. */
    private ArrayList<Card> crib;

    /** The set of cards played by the pone during the pegging phase. */
    private ArrayList<Card> ponePeggingCards;

    /** The set of cards played by the dealer during the pegging phase. */
    private ArrayList<Card> dealerPeggingCards;

    /** A GameManager to manipulate the data. */
    @SuppressWarnings("unused")
    private GameManager gm = new GameManager(this);

    /**
     * State of the game.
     */
    private GameState state;
    
    /**
     * Arraylist of card images.
     */
    private ArrayList<Card> standardDeck;
    
    /**
     * Cards currently displayed in the deck.
     */
    private ArrayList<Card> cardsInDeck;
    
    /**
     * Cards currently displayed in center of board.
     */
    private ArrayList<Card> cardsInPlay;
    
    /**
     * Cards currently displayed in the player's hand.
     */
    private ArrayList<Card> cardsInHand;
    
    /**
     * Cards currently displayed in the crib.
     */
    private ArrayList<Card> cardsInCrib;
    
    /**
     * Cards currently displayed in the opponent's hand.
     */
    private ArrayList<Card> cardsInOpponentHand;
    
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

        ponePeggingCards = new ArrayList<Card>();
        dealerPeggingCards = new ArrayList<Card>();
        crib = new ArrayList<Card>();
        // gm.initPlayers(numPlayers, playerList);
        // gm.initPeggingTotal();
    }

    /**
     * Game constructor
     * This was created for testing Game. In particular,
     * for testing methods related
     */
    public Game() {
        ponePeggingCards = new ArrayList<Card>();
        dealerPeggingCards = new ArrayList<Card>();
        crib = new ArrayList<Card>();
        peggingTotal = 0;
        state = GameState.START_GAME;
        standardDeck = new ArrayList<Card>();
        cardsInDeck = new ArrayList<Card>();
        cardsInPlay = new ArrayList<Card>();
        cardsInHand = new ArrayList<Card>();
        cardsInCrib = new ArrayList<Card>();
        cardsInOpponentHand = new ArrayList<Card>();
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
     * Sets the pone's pegging cards to the parameter.
     *
     * @param ponePegCards
     *            is an ArrayList of Card objects.
     */
    public void setPonePeggingCards(ArrayList<Card> ponePegCards) {
        ponePeggingCards = ponePegCards;
    }

    /**
     * Sets the dealer's pegging cards to the parameter.
     *
     * @param dealerPegCards
     *            is an ArrayList of Card objects.
     */
    public void setDealerPeggingCards(ArrayList<Card> dealerPegCards) {
        dealerPeggingCards = dealerPegCards;
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
     * Returns the pegging total for this game.
     *
     * @return the pegging total.
     */
    public int getPeggingTotal() {
        return peggingTotal;
    }

    /**
     * Returns the pone's pegging cards as an ArrayList of Card objects.
     *
     * @return the pone's pegging cards.
     */
    public ArrayList<Card> getPonePeggingCards() {
        return ponePeggingCards;
    }

    /**
     * Returns the dealers's pegging cards as an ArrayList of Card objects.
     *
     * @return the dealer's pegging cards.
     */
    public ArrayList<Card> getDealerPeggingCards() {
        return dealerPeggingCards;
    }

    /**
     * Returns the list of players.
     *
     * @return an ArrayList of players.
     */
    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    /**
     * Returns the crib.
     *
     * @return the crib as an ArrayList of Card objects.
     */
    public ArrayList<Card> getCrib() {
        return crib;
    }
    
    /**
     * Get the state of the game.
     * @return state
     */
    public GameState getState() {
        return this.state;
    }
    
    /**
     * Set the state of the game.
     * @param state
     */
    public void setState(GameState state) {
        this.state = state;
    }
    
    /**
     * Get the standard deck.
     * @return standardDeck
     */
    public ArrayList<Card> getStandardDeck() {
        return this.standardDeck;
    }
    
    /**
     * Get the cards in the deck.
     * @return cardsInDeck
     */
    public ArrayList<Card> getCardsInDeck() {
        return this.cardsInDeck;
    }
    
    /**
     * Get the cards currently in play.
     * @return cardsInPlay
     */
    public ArrayList<Card> getCardsInPlay() {
        return this.cardsInPlay;
    }
    
    /**
     * Get the cards in the player's hand.
     * @return cardsInHand
     */
    public ArrayList<Card> getCardsInHand() {
        return this.cardsInHand;
    }
    
    /**
     * Get the cards in the crib.
     * @return cardsInCrib
     */
    public ArrayList<Card> getCardsInCrib() {
        return this.cardsInCrib;
    }
    
    /**
     * Get the cards in the opponent's hand.
     * @return cardsInOpponentHand
     */
    public ArrayList<Card> getCardsInOpponentHand() {
        return this.cardsInOpponentHand;
    }

}
