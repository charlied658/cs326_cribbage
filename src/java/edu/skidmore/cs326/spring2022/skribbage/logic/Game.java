package edu.skidmore.cs326.spring2022.skribbage.logic;

import java.util.ArrayList;
//import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.Card;

/**
 * Game contains the state of the game. It has a deck, a list of players, a
 * pegging total, a list of cards in the crib, and lists of cards played during
 * pegging play by the pone and dealer. It also contains methods that are
 * useful to the various phases of the game. Currently, a key assumption for
 * this class is that there are only two players.
 * 
 * TODO (DSR): Game functionality needs to move to the common package
 * TODO (DSR): Lets talk through the design of Game...

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

	  /**
	   * Game constructor. It initializes the list of players
	   * and the pegging total. It assumes that there are
	   * two players.
	   *
	   * @param numPlayers is the number of players for this
	   * game.
	   */
    public Game(int numPlayers) {

        ponePeggingCards = new ArrayList<Card>();
        dealerPeggingCards = new ArrayList<Card>();
        crib = new ArrayList<Card>();

        initPlayers(numPlayers);
        initPeggingTotal();
    }

    /**
     * Game constructor. It initializes the pegging total.
     * This was created for testing Game.
     */
    public Game() {
        ponePeggingCards = new ArrayList<Card>();
        dealerPeggingCards = new ArrayList<Card>();
        crib = new ArrayList<Card>();
        peggingTotal = 0;
    }

	  /**
	   * Initializes the ArrayList of Player objects given the
	   * number of players for this game. However, there is
	   * the assumption, for now, that the number of players
	   * is 2.
	   *
	   * @param numPlayers is the number of players
	   */
    public void initPlayers(int numPlayers) {

        for (int i = 0; i < numPlayers; i++) {
            addPlayer(new Player());
        }
    }

    /**
     * Add a player to the player list.
     *
     * @param p is the player to add to the player list.
     */
    public void addPlayer(Player p) {
        playerList.add(p);
    }

	/**
	 * Initializes the pegging total to 0.
	 */
    public void initPeggingTotal() {
        peggingTotal = 0;
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
	  * Sets the pone's pegging cards to the parameter.
	  *
	  * @param ponePegCards is an ArrayList of Card objects.
	  */
    public void setPonePeggingCards(ArrayList<Card> ponePegCards) {
        ponePeggingCards = ponePegCards;
    }

  	/**
	  * Sets the dealer's pegging cards to the parameter.
	  *
	  * @param dealerPegCards is an ArrayList of Card objects.
	  */
    public void setDealerPeggingCards(ArrayList<Card> dealerPegCards) {
        dealerPeggingCards = dealerPegCards;
    }

	 /**
	  * Add the parameter Card to the pone's pegging cards.
	  *
	  * @param c is the Card to add to the list of the pone's pegging cards.
	  */
    public void addPonePeggingCard(Card c) {
        ponePeggingCards.add(c);
    }

	 /**
	  * Add the parameter Card to the dealer's pegging cards.
	  *
	  * @param c is the Card to add to the list of the dealer's
	  * pegging cards.
	  */
    public void addDealerPeggingCard(Card c) {
        dealerPeggingCards.add(c);
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
	  * Takes in the amount to add to the pegging total
	  * and adds it to the pegging total if the amount
	  * to add plus the current pegging total does not exceed 31.
	  * If it exceeds 31, this method returns false.
	  * Otherwise, it returns true.
	  *
	  * @param amountToAdd is the amount of points to add
	  * to the pegging total.
	  * @return true iff amountToAdd + the pegging total <= 31.
	  */
    public boolean addToPeggingTotal(int amountToAdd) {
        if (amountToAdd + peggingTotal > 31) {
            return false;
        } else {
            peggingTotal += amountToAdd;
            return true;
        }
    }

	/**
	 * Returns the index in playerList where the dealer is or
	 * -1 if there is no dealer.
	 *
	 * @return the index in playerList where the dealer is or
	 * -1 if there is no dealer.
	 */
    public int getDealerIdx() {
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).isDealer()) {
                return i;
            }
        }
        return -1;
    }


}
